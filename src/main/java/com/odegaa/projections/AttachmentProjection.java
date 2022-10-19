package com.odegaa.projections;

import com.odegaa.models.Attachment;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Attachment.class)
public interface AttachmentProjection {

    Integer getId();

    String getOriginalName();

}
