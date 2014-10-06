package com.sopovs.moradanen.flyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopovs.moradanen.flyway.domain.TestEntity;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

}
