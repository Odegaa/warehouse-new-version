package com.odegaa.projections;

import com.odegaa.models.Supplier;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface SupplierProjection {
}
