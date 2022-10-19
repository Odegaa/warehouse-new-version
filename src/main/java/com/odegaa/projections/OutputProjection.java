package com.odegaa.projections;

import com.odegaa.models.Output;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Output.class)
public interface OutputProjection {
}