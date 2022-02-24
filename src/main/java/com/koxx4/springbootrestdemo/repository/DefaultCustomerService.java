package com.koxx4.springbootrestdemo.repository;


import com.koxx4.springbootrestdemo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DefaultCustomerService implements CustomerService{

    @Autowired
    @Qualifier("defaultCustomerRepository")
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Transactional
    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteCustomerById(id);
    }
}
