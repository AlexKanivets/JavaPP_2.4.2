package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User getUserById(int id);
    void createUser(User user);
    void updateUser(int id, User updatedUser);
    void deleteUser(int id);
    void createUsersTable();
}
