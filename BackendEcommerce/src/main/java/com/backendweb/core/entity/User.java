package com.backendweb.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6484668402933270218L;

	public User() {

	}

	// Constructor

	public User(Integer id, String name, String last_name, Date birthday, Long dni, String email, String phone,
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

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", unique = false, nullable = false, length = 100)
	private String name;

	@Column(name = "last_name", unique = false, nullable = true, length = 100)
	private String last_name;

	@Column(name = "birthday", unique = false, nullable = true)
	private Date birthday;

	@Column(name = "dni", unique = true, nullable = true)
	private Long dni;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "phone", unique = false, nullable = true, length = 40)
	private String phone;

	@Column(name = "address", unique = false, nullable = true, length = 225)
	private String address;

	@Column(name = "city", unique = false, nullable = true, length = 225)
	private String city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role", nullable = false)
	private Set<Role> role;

	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;

	@Column(name = "PASSWORD", unique = false, nullable = false, length = 100)
	private String password;

	@Column(columnDefinition = "boolean default true")
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
		return "User [id=" + id + ", name=" + name + ", last_name=" + last_name + ", birthday=" + birthday + ", dni="
				+ dni + ", email=" + email + ", phone=" + phone + ", address=" + address + ", city=" + city + ", role="
				+ role + ", username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}

}
