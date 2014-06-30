package it.unibz.teststore.repository;

import it.unibz.teststore.entity.TestCase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase,Integer>{ 

}
