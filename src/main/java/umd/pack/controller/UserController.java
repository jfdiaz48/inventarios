package umd.pack.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umd.pack.entity.User;
import umd.pack.repository.RoleRepository;
import umd.pack.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserRepository userReposirotory;
	
	@Autowired
	private RoleRepository RoleReposirotory;
	
	@GetMapping
	public List<User> listUsers(){
		return userReposirotory.findAll();
	}
	
	@PostMapping(value="/create")	
	public User createUser(@RequestBody User user){
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		user.setCreatedAt(new Date());
		user.setCreatedBy("LoginForm");
		user.setRole(RoleReposirotory.findById(1).get());
		user.setPassword(pe.encode(user.getPassword()));
		return userReposirotory.save(user);
	}

}
