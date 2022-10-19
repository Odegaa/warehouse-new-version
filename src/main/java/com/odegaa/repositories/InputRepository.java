package com.odegaa.repositories;

import com.odegaa.models.Input;
import com.odegaa.projections.InputProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = InputProjection.class)
public interface InputRepository extends JpaRepository<Input, Long> {

    boolean existsInputByCode(String code);

}