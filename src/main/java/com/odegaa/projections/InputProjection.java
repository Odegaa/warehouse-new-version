package com.odegaa.projections;

import com.odegaa.models.Input;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Input.class)
public interface InputProjection {
}
