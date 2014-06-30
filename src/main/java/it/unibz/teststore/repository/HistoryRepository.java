package it.unibz.teststore.repository;

import it.unibz.teststore.entity.History;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer>{ 

}
