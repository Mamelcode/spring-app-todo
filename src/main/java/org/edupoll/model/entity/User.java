package org.edupoll.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class User {
	
	@NotNull
	@NotBlank
	String id;
	
	@NotNull
	@NotBlank
	String password;
	
	public User() {
		super();
	}

	public User(@NotNull @NotBlank String id, @NotNull @NotBlank String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
