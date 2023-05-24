package ru.web.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.web.model.User;

import javax.persistence.TypedQuery;

@Repository
@Transactional
public class UserRepo {
    @Autowired
    SessionFactory sessionFactory;

    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUserByEmail(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where email = :email");
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
