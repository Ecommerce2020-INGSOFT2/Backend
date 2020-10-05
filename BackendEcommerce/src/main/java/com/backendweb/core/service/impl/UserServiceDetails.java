package com.backendweb.core.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backendweb.core.entity.Role;

import com.backendweb.core.repository.UserRepository;

@Service("userServiceDetails")
public class UserServiceDetails implements UserDetailsService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.backendweb.core.entity.User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));
		List<GrantedAuthority> authorities = buildAuthorities(user.getRole());
		return buildUser(user, authorities);
	}

	private User buildUser(com.backendweb.core.entity.User user, List<GrantedAuthority> authorities ) {
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities (Set<Role> roles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>(); 
		for(Role role : roles) {
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new ArrayList<GrantedAuthority>(auths);
		
	}
}
