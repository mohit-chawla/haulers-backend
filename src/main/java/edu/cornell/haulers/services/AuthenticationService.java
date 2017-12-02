package edu.cornell.haulers.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.cornell.haulers.entity.AuthEntity;
import edu.cornell.haulers.repositories.AuthenticationRespository;

/**
 * @author mohitchawla
 *
 */
@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	AuthenticationRespository authenticationRespository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("Searching for user: " + username);
		AuthEntity user = authenticationRespository.findByUsername(username);
		if (user == null) {
			System.err.println("User not found in db");
			throw new UsernameNotFoundException("User not found");
		} else {
			System.err.println("User found:" + username);
			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
			grantedAuthorities.add(grantedAuthority);
			return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
		}
	}

}
