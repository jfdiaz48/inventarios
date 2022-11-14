package umd.pack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import umd.pack.entity.User;
import umd.pack.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository
		.findOneByEmail(email)
		.orElseThrow(() -> new UsernameNotFoundException("The user with email " + email + " does not exists"));
		
		return new UserDetailsImpl(user);
	}
}
