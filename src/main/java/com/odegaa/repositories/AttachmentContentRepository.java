package com.odegaa.repositories;

import com.odegaa.models.AttachmentContent;
import com.odegaa.projections.AttachmentContentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = AttachmentContentProjection.class)
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {

}