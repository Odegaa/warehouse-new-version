package com.odegaa.repositories;

import com.odegaa.models.Client;
import com.odegaa.projections.ClientProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ClientProjection.class)
public interface ClientRepository extends JpaRepository<Client, Long> {

}