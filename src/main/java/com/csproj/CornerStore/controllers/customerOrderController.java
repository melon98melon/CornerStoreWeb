package com.csproj.CornerStore.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.csproj.CornerStore.entity.customerOrder;
import com.csproj.CornerStore.service.customerOrderService;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class customerOrderController {

    private final customerOrderService customerOrderService;

    public customerOrderController(customerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @GetMapping
    public List<customerOrder> getAllOrders() {
        return customerOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<customerOrder> getOrderById(@PathVariable int id) {
        return customerOrderService.getOrderById(id);
    }

    @PostMapping
    public customerOrder createOrder(@RequestBody customerOrder order) {
        return customerOrderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        customerOrderService.deleteOrder(id);
    }
}


