package com.odegaa.projections;

import com.odegaa.models.OutputProducts;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = OutputProducts.class)
public interface OutputProductsProjection {
}
