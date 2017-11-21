package ru.yandex.startapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@Column(name = "admin_id")
	private Integer adminId;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
}
