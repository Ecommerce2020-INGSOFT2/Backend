package com.backendweb.core.coverter;

import org.springframework.stereotype.Component;
import com.backendweb.core.entity.Role;
import com.backendweb.core.model.RoleModel;

@Component("roleConverter")
public class RoleConverter {
	
	public Role convertRoleModelToRole(RoleModel roleModel) {
		Role role = new Role();
		role.setId(roleModel.getId());
		role.setName(roleModel.getName());
		return role;
	}
	
	public RoleModel convertUserToModelUser(Role role) {
		RoleModel roleModel = new RoleModel();
		roleModel.setId(role.getId());
		roleModel.setName(role.getName());
		return roleModel;
	}

}
