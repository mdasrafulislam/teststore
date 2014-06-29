package it.unibz.teststore.repository;

import it.unibz.teststore.entity.Build;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildRepository extends JpaRepository<Build,Integer>{ 

}
