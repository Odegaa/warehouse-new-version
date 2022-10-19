package com.odegaa.repositories;

import com.odegaa.models.Employee;
import com.odegaa.projections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmployeeProjection.class)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}