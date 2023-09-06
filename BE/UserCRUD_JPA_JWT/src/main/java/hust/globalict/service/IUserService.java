package hust.globalict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import hust.globalict.entity.User;

public interface IUserService{

	List<User> getAllUsers();
	
	Optional<User> findByUserName(String username);
	
	User findByUserId(long id);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(long id);
}
