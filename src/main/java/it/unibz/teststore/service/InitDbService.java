package it.unibz.teststore.service;

import it.unibz.teststore.entity.Blog;
import it.unibz.teststore.entity.Item;
import it.unibz.teststore.entity.Project;
import it.unibz.teststore.entity.Role;
import it.unibz.teststore.entity.User;
import it.unibz.teststore.repository.BlogRepository;
import it.unibz.teststore.repository.BuildRepository;
import it.unibz.teststore.repository.HistoryRepository;
import it.unibz.teststore.repository.ItemRepository;
import it.unibz.teststore.repository.ProjectRepository;
import it.unibz.teststore.repository.RoleRepository;
import it.unibz.teststore.repository.TestCaseRepository;
import it.unibz.teststore.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
			
	@Autowired
	private TestCaseRepository testCaseRepository;
	
	@Autowired
	private BuildRepository buildRepository;

	@Autowired
	private HistoryRepository historyRepository;

	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);

		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavavids.setUser(userAdmin);
		blogRepository.save(blogJavavids);

		Item item1 = new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);

		Item item2 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
		Item item3 = new Item();
		item3.setBlog(blogJavavids);
		item3.setTitle("thrirds");
		item3.setLink("http://www.codeporject.com");
		item3.setPublishedDate(new Date());
		itemRepository.save(item3);
		
		Item item4 = new Item();
		item4.setBlog(blogJavavids);
		item4.setTitle("fourth");
		item4.setLink("http://www.coderoject.com");
		item4.setPublishedDate(new Date());
		itemRepository.save(item4);
		
		Project project1 = new Project();
		project1.setName("archiva-all-maven-3.x");
		project1.setUrl("https://builds.apache.org/job/archiva-all-maven-3.x-jdk-1.6-IBM-JDK16/");
     	projectRepository.save(project1);
     	
     	Project project2 = new Project();
		project2.setName("ZooKeeper");
		project2.setUrl("https://builds.apache.org/job/ZooKeeper-trunk-ibm6/");
     	projectRepository.save(project2);
		
	}
}
