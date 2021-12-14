package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setLastname(updatedUser.getLastname());
        user.setAge(updatedUser.getAge());
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.find(User.class, name);
    }
}
