package com.odegaa.repositories;

import com.odegaa.models.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    boolean existsByGenerationName(String generationName);
}