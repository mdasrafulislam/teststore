package it.unibz.teststore.repository;

import it.unibz.teststore.entity.Technique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechniqueRepository extends JpaRepository<Technique, Integer> {

}
