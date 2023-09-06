package hust.globalict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.globalict.entity.User;
import hust.globalict.repository.IUserRepository;


@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository repository;
	
	
	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public Optional<User> findByUserName(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User findByUserId(long id) {
		return repository.findById(id).get();
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
