package com.odegaa.projections;

import com.odegaa.models.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Client.class)
public interface ClientProjection {

    Integer getId();

    String getSurname();

    String getName();

    String getPhoneNumber();

}
