package it.unibz.teststore.repository;

import java.util.List;

import it.unibz.teststore.entity.Build;
import it.unibz.teststore.entity.History;
import it.unibz.teststore.entity.TestCase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer>{ 
	
	

}
