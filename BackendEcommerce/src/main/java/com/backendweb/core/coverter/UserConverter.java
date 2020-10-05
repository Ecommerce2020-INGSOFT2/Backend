package com.backendweb.core.coverter;

import org.springframework.stereotype.Component;

import com.backendweb.core.entity.User;
import com.backendweb.core.model.ModelUser;

@Component("userConverter")
public class UserConverter {
	
	public User convertModelUserToUser(ModelUser modelUser) {
		User user = new User();
		user.setAddress(modelUser.getAddress());
		user.setBirthday(modelUser.getBirthday());
		user.setCity(modelUser.getCity());
		user.setDni(modelUser.getDni());
		user.setEmail(modelUser.getEmail());
		user.setId(modelUser.getId());
		user.setLast_name(modelUser.getLast_name());
		user.setName(modelUser.getName());
		user.setPassword(modelUser.getPassword());
		user.setPhone(modelUser.getPhone());
		user.setRole(modelUser.getRole());
		user.setUsername(modelUser.getUsername());
		user.setEnabled(modelUser.getEnabled());
		return user;
	}
	
	public ModelUser convertUserToModelUser(User user) {
		ModelUser modelUser = new ModelUser();
		modelUser.setAddress(user.getAddress());
		modelUser.setBirthday(user.getBirthday());
		modelUser.setCity(user.getCity());
		modelUser.setDni(user.getDni());
		modelUser.setEmail(user.getEmail());
		modelUser.setId(user.getId());
		modelUser.setLast_name(user.getLast_name());
		modelUser.setName(user.getName());
		modelUser.setPassword(user.getPassword());
		modelUser.setPhone(user.getPhone());
		modelUser.setRole(user.getRole());
		modelUser.setUsername(user.getUsername());
		modelUser.setEnabled(user.getEnabled());
		return modelUser;
	}
}
