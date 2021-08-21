package com.koxx4.springbootrestdemo.repository;

import com.koxx4.springbootrestdemo.data.DogStatus;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface DogStatusRepository extends JpaRepository<DogStatus, Long>{

}
