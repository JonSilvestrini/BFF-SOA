package jonsilvestrini.BFFSOA.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jonsilvestrini.BFFSOA.models.User;

@Service
public class UserService implements UserDetailsService{

	@Value("${user.pass}")
	String pass;

	public User getUser() {
		return User.builder()
				.user("user")
				.pass(pass)
				.build();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return User.builder()
				.user(username)
				.pass(pass)
				.build();
	}

}
