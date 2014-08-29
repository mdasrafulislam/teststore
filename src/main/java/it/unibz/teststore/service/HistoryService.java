package it.unibz.teststore.service;

import it.unibz.teststore.entity.History;
import it.unibz.teststore.repository.HistoryRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	public void save( History history) {
		historyRepository.save(history);
	}
	
	public History findHistoryById(int id) {
		return historyRepository.findOne(id);
	}
	
	public List<History> findAllBuild() {
		return historyRepository.findAll();
	}
	
	public void delete(History history){
		historyRepository.delete(history);
	}
	
	public List<History> SelectTestInstanceby(int testId,int buildId){
		return historyRepository.findAll();
	}

}
