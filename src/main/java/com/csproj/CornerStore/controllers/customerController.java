package com.csproj.CornerStore.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.csproj.CornerStore.entity.customer;
import com.csproj.CornerStore.service.customerService;
import java.util.List;

@RestController
@RequestMapping("/customers")
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
    public ResponseEntity<customer> getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public customer createCustomer(@RequestBody customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<customer> updateCustomer(@PathVariable Integer id, @RequestBody customer customer) {
        try {
            return ResponseEntity.ok(customerService.updateCustomer(id, customer));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}

