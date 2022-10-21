package com.odegaa.controllers;

import com.odegaa.models.Attachment;
import com.odegaa.services.AttachmentService;
import com.odegaa.templates.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService service;

    @PostMapping
    private ResponseEntity<Result> addAttachment(@RequestBody Attachment attachment) {
        Result result = service.addAttachment(attachment);
        return ResponseEntity
                .status(result.getStatus())
                .body(result);
    }

    @GetMapping
    private ResponseEntity<List<Attachment>> getAllAttachments() {
        List<Attachment> attachments = service.getAttachments();
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/{attachmentId}")
    private ResponseEntity<Attachment> getAttachmentById(@PathVariable Long attachmentId) {
        return ResponseEntity.ok(service.getAttachmentById(attachmentId));
    }

    @PutMapping("/{attachmentId}")
    private ResponseEntity<Result> updateAttachment(@PathVariable Long attachmentId,
                                                    @RequestBody Attachment attachment) {
        Result result = service.updateAttachment(attachmentId, attachment);
        return ResponseEntity
                .status(result.getStatus())
                .body(result);
    }

    @DeleteMapping("/{attachmentId}")
    private ResponseEntity<Result> deleteAttachment(@PathVariable Long attachmentId) {
        Result result = service.deleteAttachment(attachmentId);
        return ResponseEntity.status(result.getStatus()).body(result);

    }


}