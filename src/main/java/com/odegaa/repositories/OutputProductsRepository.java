package com.odegaa.repositories;

import com.odegaa.models.OutputProducts;
import com.odegaa.projections.OutputProductsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = OutputProductsProjection.class)
public interface OutputProductsRepository extends JpaRepository<OutputProducts, Long> {


}