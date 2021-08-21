package com.koxx4.springbootrestdemo.repository;


import com.koxx4.springbootrestdemo.data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DefaultCustomerRepository implements CustomerRepository{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager
                .createQuery("SELECT c FROM Customer c" , Customer.class)
                .getResultList();
    }

    @Override
    public Customer getCustomerById(int id) {
        return (Customer) entityManager.
                createQuery("SELECT c FROM Customer c where c.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        entityManager
                .createQuery("DELETE FROM Customer WHERE id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
