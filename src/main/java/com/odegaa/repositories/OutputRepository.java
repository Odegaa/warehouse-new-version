package com.odegaa.repositories;

import com.odegaa.models.Output;
import com.odegaa.projections.OutputProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = OutputProjection.class)
public interface OutputRepository extends JpaRepository<Output, Long> {



}
