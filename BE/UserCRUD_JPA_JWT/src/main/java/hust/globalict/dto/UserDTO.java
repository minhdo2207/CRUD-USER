package hust.globalict.dto;

import java.util.List;

import hust.globalict.entity.Role;
import hust.globalict.entity.User;

public class UserDTO {
	private String username;
	private List<Role> roles;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
