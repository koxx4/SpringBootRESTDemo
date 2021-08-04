package com.koxx4.springbootrestdemo.repository;

import com.koxx4.springbootrestdemo.data.DogStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DogStatusRepository extends JpaRepository<DogStatus, Long>{

}
