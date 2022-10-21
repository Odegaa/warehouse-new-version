package com.odegaa.services;

import com.odegaa.models.Attachment;
import com.odegaa.models.AttachmentContent;
import com.odegaa.repositories.AttachmentContentRepository;
import com.odegaa.repositories.AttachmentRepository;
import com.odegaa.templates.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachmentContentService {

    @Autowired
    private AttachmentContentRepository contentRepository;

    @Autowired
    private AttachmentRepository repository;

    public Result addAttachmentContent(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            String contentType = file.getContentType();
            long size = file.getSize();

            String nameForSystem = UUID.randomUUID().toString();
            Attachment attachment =
                    new Attachment(null, originalFilename, size, contentType, nameForSystem);

            assert originalFilename != null;
            nameForSystem += originalFilename.substring(originalFilename.lastIndexOf("."));

            repository.save(attachment);
            try {
                byte[] bytes = file.getBytes();
                AttachmentContent attachmentContent = new AttachmentContent(null, bytes, attachment);
                contentRepository.save(attachmentContent);
                Path path = Paths.get("files/", nameForSystem);

                Files.copy(file.getInputStream(), path);
                return new Result("Successfully saved!", true, HttpStatus.CREATED);
            } catch (IOException e) {
                e.printStackTrace();
                return new Result("File is not saved!", false, HttpStatus.EXPECTATION_FAILED);
            }
        }
        return new Result("An error occurred", false, HttpStatus.EXPECTATION_FAILED);
    }

    public void getAttachmentContent(Long attachmentContentId, HttpServletResponse response) {
        Optional<Attachment> optionalAttachment = repository.findById(attachmentContentId);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> contentOptional = contentRepository.findById(attachment.getId());
            if (contentOptional.isPresent()) {
                AttachmentContent attachmentContent = contentOptional.get();
                byte[] bytes = attachmentContent.getBytes();

                response.setHeader("Content-Disposition",
                        "attachment; filename = \"" + attachment.getOriginalName() + "\"");
                response.setContentType(attachment.getContentType());
                try {
                    FileCopyUtils.copy(bytes, response.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Result deleteAttachment(Long attachmentContentId) {
        Optional<AttachmentContent> attachmentContentOptional = contentRepository.findById(attachmentContentId);
        if (attachmentContentOptional.isPresent()) {
            contentRepository.deleteById(attachmentContentId);
            return new Result("Attachment Content deleted!", true, HttpStatus.ACCEPTED);
        }
        return new Result("Attachment content not found or Exception!", false, HttpStatus.NOT_FOUND);
    }

}
