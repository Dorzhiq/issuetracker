package com.axmor.dao;

import com.axmor.user.User;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;

import static com.axmor.Main.sessionFactory;

public class UserDao {
    public User getUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        session.save(new User("perwendel", "$2a$10$h.dl5J86rGH7I8bD9bZeZe", "$2a$10$h.dl5J86rGH7I8bD9bZeZeci0pDt0.VwFTGujlnEaZXPf/q7vM5wO"));
        session.save(new User("davidase",  "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe", "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe1HlCS4bZJ18JuywdEMLT83E1KDmUhCy"));
        session.save(new User("federico",  "$2a$10$E3DgchtVry3qlYlzJCsyxe", "$2a$10$E3DgchtVry3qlYlzJCsyxeSK0fftK4v0ynetVCuDdxGVl1obL.ln2"));
        User result = session.get(User.class, username);
        session.close();
        return result;
    }

    public List<User> getAllUsername() {
        Session session =  sessionFactory.openSession();
        List<User> result = (List<User>) session.createQuery("from User").list();
        session.close();
        return result;
    }
}
