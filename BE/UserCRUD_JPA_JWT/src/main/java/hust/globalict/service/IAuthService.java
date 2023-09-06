package hust.globalict.service;

import java.util.Optional;

import hust.globalict.dto.UserInput;
import hust.globalict.entity.User;

public interface IAuthService {
    public Optional<User> AddUser(UserInput user);
}
