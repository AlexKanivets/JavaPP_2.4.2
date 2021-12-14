package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Long id);
    void createUser(User user);
    void updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
    User getUserByName(String name);
}
