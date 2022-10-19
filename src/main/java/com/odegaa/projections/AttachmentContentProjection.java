package com.odegaa.projections;

import com.odegaa.models.Attachment;
import com.odegaa.models.AttachmentContent;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = AttachmentContent.class)
public interface AttachmentContentProjection {

    Integer getId();

}