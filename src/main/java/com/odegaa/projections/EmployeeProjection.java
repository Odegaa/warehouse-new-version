package com.odegaa.projections;

import com.odegaa.models.Employee;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Employee.class)
public interface EmployeeProjection {
}
