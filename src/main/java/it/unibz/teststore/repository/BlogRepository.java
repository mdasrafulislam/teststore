package it.unibz.teststore.repository;

import it.unibz.teststore.entity.Blog;
import it.unibz.teststore.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User user);
}
