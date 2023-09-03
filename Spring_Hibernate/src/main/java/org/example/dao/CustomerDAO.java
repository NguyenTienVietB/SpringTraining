package org.example.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.example.entities.Customer;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "customerDAO")
public class CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(rollbackFor = RuntimeException.class) // Rollback for runtime exceptions
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
    }

    @Transactional(rollbackFor = RuntimeException.class) // Rollback for runtime exceptions
    public void update(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Customer findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Customer.class, id);
    }

    @Transactional(rollbackFor = RuntimeException.class) // Rollback for runtime exceptions
    public void delete(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
    }

    @Transactional(rollbackFor = RuntimeException.class) // Rollback for runtime exceptions
    public void test(Customer customer) {
        save(customer);
        demoException();
    }

    private void demoException() {
        // Throwing a runtime exception to trigger rollback
        throw new RuntimeException("Demo throw runtime exception");
    }
}
