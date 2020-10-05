package com.backendweb.core.exception;

public class CusFieldValidationException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 5697024813422693990L;
private String fieldName;
	
	public CusFieldValidationException(String message, String fieldName) {
		super(message);
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
}
