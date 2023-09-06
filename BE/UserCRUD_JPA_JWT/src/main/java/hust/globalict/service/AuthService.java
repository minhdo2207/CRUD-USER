package hust.globalict.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hust.globalict.dto.UserInput;
import hust.globalict.entity.ERole;
import hust.globalict.entity.User;
import hust.globalict.repository.IRoleRepository;
import hust.globalict.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService implements IAuthService {
    private final IUserRepository usersRepository;
    private final IRoleRepository roleRepository;

	@Override
	public Optional<User> AddUser(UserInput user) {
		User newUser = new User();
      newUser.setUsername(user.getUsername());
      newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
      newUser.setRoles(Arrays.asList(roleRepository.findByName(ERole.USER)));
      return Optional.of(usersRepository.save(newUser));
	}
}
