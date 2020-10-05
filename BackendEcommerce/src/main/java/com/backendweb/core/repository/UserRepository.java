package com.backendweb.core.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backendweb.core.entity.User;
import com.backendweb.core.model.ModelUser;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {
    //public abstract User findByName(String name);
    //public abstract List<User> findByLast_name(String last_name);
	public Optional<User> findByUsername(String username);
	public Boolean existsByUsername(String username);
	public Boolean existsByEmail(String email);
    
}