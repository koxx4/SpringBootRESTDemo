package com.koxx4.springbootrestdemo.repository;

import com.koxx4.springbootrestdemo.entities.DogStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface DogStatusRepository extends JpaRepository<DogStatus, Long>{

}
