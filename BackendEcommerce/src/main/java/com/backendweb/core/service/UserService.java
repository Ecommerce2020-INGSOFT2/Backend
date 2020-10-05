package com.backendweb.core.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.backendweb.core.model.ModelUser;

@Service("userService")
public interface UserService {
	
	
	public abstract ModelUser addUser(ModelUser modelUser) throws Exception;
	public abstract List<ModelUser> listAllUsers();

}
