package it.unibz.teststore.repository;

import it.unibz.teststore.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
