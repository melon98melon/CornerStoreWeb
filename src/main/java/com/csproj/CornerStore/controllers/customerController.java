package com.csproj.CornerStore.controllers;

import org.springframework.web.bind.annotation.*;
import com.csproj.CornerStore.entity.customer;
import com.csproj.CornerStore.service.customerService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class customerController {

    private final customerService customerService;

    public customerController(customerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<customer> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public customer createCustomer(@RequestBody customer customer) {
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}


