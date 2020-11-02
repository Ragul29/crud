package io.crudoperation.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.crudoperation.project.entity.Customer;
import io.crudoperation.project.repository.CustomerRepository;

@Controller
@RequestMapping("/customers/")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Customer customer) {
        return "add-customer";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }
    
    @PostMapping("add")
    public String addStudent(@Validated Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-customer";
        }

        customerRepository.save(customer);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
    	Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("customer", customer);
        return "update-customer";
    }
    
    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") String id,@Validated  Customer customer, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
        	customer.setId(id);
            return "update-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") String id, Model model) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        customerRepository.delete(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }
}
