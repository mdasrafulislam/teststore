package it.unibz.teststore.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.unibz.teststore.entity.Blog;
import it.unibz.teststore.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog, Pageable pageable);
	
	Item findByBlogAndLink(Blog blog, String link);
}
