package com.odegaa.projections;

import com.odegaa.models.Measurement;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Measurement.class)
public interface MeasurementProjection {
}
