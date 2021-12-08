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
        createUsersTable();
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
//        return entityManager.createQuery("select u from User u where u.id = :id", User.class)
//                .setParameter("id", id)
//                .getSingleResult();
        return entityManager.find(User.class, id);
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
//        entityManager.createQuery("update User u set u.name = :name,u.lastname = :lastname, u.age = :age where u.id = :id")
//                .setParameter("id", updatedUser.getId())
//                .setParameter("name", updatedUser.getName())
//                .setParameter("lastname", updatedUser.getLastname())
//                .setParameter("age", updatedUser.getAge())
//                .executeUpdate();
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setLastname(updatedUser.getLastname());
        user.setAge(updatedUser.getAge());
    }

    @Override
    public void deleteUser(int id) {
//        entityManager.createQuery("delete from User u where u.id = :id")
//                .setParameter("id", id)
//                .executeUpdate();
        entityManager.remove(getUserById(id));
    }

    @Override
    public void createUsersTable() {
        entityManager.createNativeQuery("create table if not exists users " +
                "(id int primary key AUTO_INCREMENT, " +
                "name varchar(30), " +
                "lastname varchar(50), " +
                "age int)").executeUpdate();
    }
}
