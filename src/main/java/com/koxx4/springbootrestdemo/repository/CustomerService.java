package com.koxx4.springbootrestdemo.repository;

import com.koxx4.springbootrestdemo.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void addCustomer(Customer customer);
    void deleteCustomerById(int id);
}
