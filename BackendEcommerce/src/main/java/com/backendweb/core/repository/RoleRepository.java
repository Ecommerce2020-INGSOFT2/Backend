package com.backendweb.core.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backendweb.core.entity.Role;
import com.backendweb.core.model.ERole;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Serializable> {
	Optional<Role> findByName(ERole name);
}
