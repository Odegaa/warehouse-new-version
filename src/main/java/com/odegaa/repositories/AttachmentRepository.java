package com.odegaa.repositories;

import com.odegaa.models.Attachment;
import com.odegaa.projections.AttachmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "attachment", excerptProjection = AttachmentProjection.class)
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    boolean existsByGenerationName(String generationName);
}