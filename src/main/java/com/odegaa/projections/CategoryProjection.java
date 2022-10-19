package com.odegaa.projections;

import com.odegaa.models.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CategoryProjection {

    Integer getId();

    String getCategoryName();
}
