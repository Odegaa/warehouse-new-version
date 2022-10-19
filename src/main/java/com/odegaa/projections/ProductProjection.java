package com.odegaa.projections;

import com.odegaa.models.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface ProductProjection {
}
