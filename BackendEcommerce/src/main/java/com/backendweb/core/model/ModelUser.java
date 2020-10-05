package com.backendweb.core.model;


import java.util.Date;
import java.util.Set;

import com.backendweb.core.entity.Role;


public class ModelUser {

	public ModelUser() {
		
	}

	// Constructor

	public ModelUser(Integer id, String name, String last_name, Date birthday, Long dni, String email, String phone,
			String address, String city, Set<Role> role, String username, String password, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.dni = dni;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.role = role;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}


	private Integer id;
	private String name;
	private String last_name;
	private Date birthday;
	private Long dni;
	private String email;
	private String phone;
	private String address;
	private String city;
	private Set<Role> role;
	private String username;
	private String password;
	private Boolean enabled;

	// Getters y Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "ModelUser [id=" + id + ", name=" + name + ", last_name=" + last_name + ", birthday=" + birthday + ", dni="
				+ dni + ", email=" + email + ", phone=" + phone + ", address=" + address + ", city=" + city + ", role="
				+ role + ", username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
}
