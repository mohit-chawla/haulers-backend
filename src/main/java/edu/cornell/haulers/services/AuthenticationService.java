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
import edu.cornell.haulers.exceptions.ErrorMessage;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.repositories.AuthenticationRespository;

/**
 * @author mohitchawla
 * 
 *         Handles authentication of all callers
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

	/**
	 * add new Authorized entity
	 * 
	 * @param username
	 * @param password
	 * @throws HaulersException
	 */
	public void addNewAuthorisedEntrity(String username, String password) throws HaulersException {
		AuthEntity authEntity = new AuthEntity(username, password);
		AuthEntity saved = authenticationRespository.save(authEntity);
		if (saved == null) {
			// TODO log here
			throw new HaulersException(new ErrorMessage("Unable to add new authorised user. "));
		}
	}

	/**
	 * remove a previously authorised entity
	 * 
	 * @param username
	 */
	public void removeEntity(String username) {
		AuthEntity entity = authenticationRespository.findByUsername(username);
		authenticationRespository.delete(entity);
	}

}
