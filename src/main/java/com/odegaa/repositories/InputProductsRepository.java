package com.odegaa.repositories;

import com.odegaa.models.InputProducts;
import com.odegaa.projections.InputProductsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "input_products", excerptProjection = InputProductsProjection.class)
public interface InputProductsRepository extends JpaRepository<InputProducts, Long> {


}