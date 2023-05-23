package ru.web.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.web.model.User;

import javax.persistence.TypedQuery;

@Repository
public class UserRepo {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

}
