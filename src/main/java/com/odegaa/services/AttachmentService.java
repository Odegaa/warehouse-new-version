package com.odegaa.services;

import com.odegaa.models.Attachment;
import com.odegaa.repositories.AttachmentRepository;
import com.odegaa.templates.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository repository;


    public Result addAttachment(Attachment attachment) {
        try {
            boolean generationName =
                    repository.existsByGenerationName(attachment.getGenerationName());
            if (generationName) {
                return new Result("Attachment is already exist", false, HttpStatus.CONFLICT);
            } else {
                Attachment newAttachment = new Attachment();
                newAttachment.setOriginalName(attachment.getOriginalName());
                newAttachment.setSize(attachment.getSize());
                newAttachment.setContentType(attachment.getContentType());
                newAttachment.setGenerationName(attachment.getGenerationName());

                repository.save(newAttachment);
                return new Result("Successfully saved!", true, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new Result("An error occurred!", false, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public List<Attachment> getAttachments() {
        return repository.findAll();
    }

    public Result updateAttachment(Long attachmentId, Attachment attachment) {
        Optional<Attachment> optionalAttachment = repository.findById(attachmentId);
        if (optionalAttachment.isPresent()) {
            Attachment updatingAttachment = optionalAttachment.get();
            updatingAttachment.setOriginalName(attachment.getOriginalName());
            updatingAttachment.setSize(attachment.getSize());
            updatingAttachment.setContentType(attachment.getContentType());
            updatingAttachment.setGenerationName(attachment.getGenerationName());

            repository.save(updatingAttachment);
            return new Result("Attachment successfully updated!", true, HttpStatus.ACCEPTED);
        }
        return new Result("Attachment is not found or Exception!", false, HttpStatus.NOT_FOUND);
    }

    public Result deleteAttachment(Long attachmentId) {
        Optional<Attachment> optionalAttachment = repository.findById(attachmentId);
        if (optionalAttachment.isPresent()) {
            repository.deleteById(attachmentId);
            return new Result("Attachment deleted!", true, HttpStatus.ACCEPTED);
        }
        return new Result("Attachment not found or Exception!", false, HttpStatus.NOT_FOUND);
    }

    public Attachment getAttachmentById(Long attachmentId) {
        return repository.findById(attachmentId).orElse(null);
    }
}