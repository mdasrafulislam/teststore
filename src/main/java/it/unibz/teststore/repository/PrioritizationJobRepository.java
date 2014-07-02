package it.unibz.teststore.repository;

import it.unibz.teststore.entity.PrioritizationJob;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrioritizationJobRepository extends JpaRepository<PrioritizationJob, Integer> {

}
