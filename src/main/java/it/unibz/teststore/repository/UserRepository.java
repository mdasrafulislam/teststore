package it.unibz.teststore.repository;

import it.unibz.teststore.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);


}
