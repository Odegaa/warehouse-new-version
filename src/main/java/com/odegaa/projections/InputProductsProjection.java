package com.odegaa.projections;

import com.odegaa.models.InputProducts;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = InputProducts.class)
public interface InputProductsProjection {
}
