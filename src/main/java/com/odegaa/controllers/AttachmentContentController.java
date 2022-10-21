package com.odegaa.controllers;

import com.odegaa.services.AttachmentContentService;
import com.odegaa.templates.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/attachmentContent")
public class AttachmentContentController {

    @Autowired
    private AttachmentContentService service;

    @PostMapping
    private ResponseEntity<Result> addAttachmentContent(MultipartHttpServletRequest request) {
        Result result = service.addAttachmentContent(request);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/{attachmentContentId}")
    private void getAttachmentContent(@PathVariable Long attachmentContentId, HttpServletResponse response) {
        service.getAttachmentContent(attachmentContentId, response);
    }

    @DeleteMapping("/{attachmentContentId}")
    private ResponseEntity<Result> deleteAttachmentContent(@PathVariable Long attachmentContentId) {
        Result result = service.deleteAttachment(attachmentContentId);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

}