package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.createUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }


    @Override
    public void updateUser(Long id, User updatedUser) {
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userDao.updateUser(id,updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}