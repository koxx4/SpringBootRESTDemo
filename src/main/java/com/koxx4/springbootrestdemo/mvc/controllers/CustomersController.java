package com.koxx4.springbootrestdemo.mvc.controllers;


import com.koxx4.springbootrestdemo.data.Customer;
import com.koxx4.springbootrestdemo.fun.RandomFactProvider;
import com.koxx4.springbootrestdemo.repository.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    @Qualifier("defaultCustomerService")
    private CustomerService customerService;

    @Autowired
    @Qualifier("hardcodedFactProvider")
    private RandomFactProvider randomFactProvider;

    @RequestMapping("/list")
    private String showListOfCustomers(Model model){
        var allCustomers = customerService.getAllCustomers();
        model.addAttribute("allCustomers", allCustomers);

        return "customers-list";
    }

    @GetMapping("/search")
    private String showCustomerById(@RequestParam("id") int id, Model model){

        var customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "customer-details";
    }

    @RequestMapping("/createForm")
    private String showCreateCustomerForm(Model model){
        model.addAttribute("customerToAdd", new Customer());
        model.addAttribute("randomFact", randomFactProvider.getRandomFact());
        return "create-customer";
    }

    @PostMapping("/create")
    private String createCustomer(@ModelAttribute("customerToAdd") @Valid Customer customer,
                                  BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()) {
            model.addAttribute("randomFact", randomFactProvider.getRandomFact());
            return "create-customer";
        }


        customerService.addCustomer(customer);

        return "redirect:list";
    }


    @ExceptionHandler(Exception.class)
    private String showCustomerErrorPage(){
        return "customer-error-page";
    }

}
