package com.odegaa.projections;

import com.odegaa.models.Warehouse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Warehouse.class)
public interface WarehouseProjection {
}