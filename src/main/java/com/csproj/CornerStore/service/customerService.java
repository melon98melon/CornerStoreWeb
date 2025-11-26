package com.csproj.CornerStore.service;
import org.springframework.stereotype.Service;

import com.csproj.CornerStore.entity.customer;
import com.csproj.CornerStore.repository.customerRepo;

import java.util.List;
import java.util.Optional;

@Service
public class customerService {

    private final customerRepo customerRepository;

    public customerService(customerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public customer createCustomer(customer customer) {
        return customerRepository.save(customer);
    }

    public customer updateCustomer(Integer id, customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    customer.setPassword(updatedCustomer.getPassword());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
