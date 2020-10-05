package com.backendweb.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backendweb.core.coverter.UserConverter;
import com.backendweb.core.entity.User;
import com.backendweb.core.exception.CusFieldValidationException;
import com.backendweb.core.model.ModelUser;
import com.backendweb.core.repository.UserRepository;
import com.backendweb.core.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;

	/*
	 * @Override public void save(ModelUser modelUser) {
	 * userRepository.save(userConverter.convertModelUserToUser(modelUser));
	 * 
	 * }
	 */

	// Comprueba si existe el nombre de usuario

	private boolean checkUsernameAvailable(String username) throws Exception {
		Optional<User> userFound = userRepository.findByUsername(username);
		if (userFound.isPresent()) {
			throw new CusFieldValidationException("Username no disponible", "username");
		}
		return true;
	}

	private boolean checkPasswordValid(ModelUser modelUser) throws Exception {
		if (modelUser.getPassword() == null || modelUser.getPassword().isEmpty()) {
			throw new CusFieldValidationException("Confirm Password es obligatorio", "confirmPassword");
		}
		return true;
	}

	@Override
	public ModelUser addUser(ModelUser modelUser) throws Exception {
		if (checkUsernameAvailable(modelUser.getUsername()) && checkPasswordValid(modelUser)) {
			String encodedPassword = bCryptPasswordEncoder.encode(modelUser.getPassword());
			modelUser.setPassword(encodedPassword);
			User user = userRepository.save(userConverter.convertModelUserToUser(modelUser));
			return userConverter.convertUserToModelUser(user);
		}
		return modelUser;
	}
	/*
	 * @Override public ModelUser addUser(ModelUser modelUser) { // TODO
	 * Auto-generated method stub User user =
	 * userRepository.save(userConverter.convertModelUserToUser(modelUser)); return
	 * userConverter.convertUserToModelUser(user); }
	 */

	@Override
	public List<ModelUser> listAllUsers() {
		List<User> users = userRepository.findAll();
		List<ModelUser> modelUsers = new ArrayList<ModelUser>();
		for (User user : users) {
			modelUsers.add(userConverter.convertUserToModelUser(user));
		}
		return modelUsers;
	}

}
