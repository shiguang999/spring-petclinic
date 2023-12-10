package org.springframework.samples.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
@Entity
@Table(name = "user")
public class User extends BaseEntity {

	@Column(name = "username")
	@NotEmpty
	private String username;
	@Column(name = "password")
	@NotEmpty
	private String password;

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//void register(User user);

	//Map<String,Object> login(String username, String password);

	//User login(String username,String password);
}
