package com.backendweb.core.exception;

public class UsernameOrIdNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9157982761409668824L;
	
	public UsernameOrIdNotFound() {
		super("Usuario o Id no encontrado");
	}
	
	public UsernameOrIdNotFound(String message) {
		super(message);
	}

}
