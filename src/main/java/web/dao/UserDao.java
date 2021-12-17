package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User getUserById(long id);
    void createUser(User user);
    void updateUser(User updatedUser);
    void deleteUser(long id);
    User getUserByName(String name);
}
