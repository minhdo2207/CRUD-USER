package hust.globalict.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hust.globalict.entity.User;

public class UserInput {
	private String username;
	private String password;

	public User toEntity() {
		return new User(username,new BCryptPasswordEncoder().encode(password));
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

}
