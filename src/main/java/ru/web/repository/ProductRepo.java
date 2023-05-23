package ru.web.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.web.model.Product;

import javax.persistence.TypedQuery;

@Repository
public class ProductRepo {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
        return query.getResultList();
    }

    @Transactional
    public void saveProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Transactional
    public Product getProductById(Integer id) {
        TypedQuery<Product> query= sessionFactory.getCurrentSession().createQuery("from Product where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    public Product deleteProductById(Integer id) {
        TypedQuery<Product> query= sessionFactory.getCurrentSession().createQuery("delete Product where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
