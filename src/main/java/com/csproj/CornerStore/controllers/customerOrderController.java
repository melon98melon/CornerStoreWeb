package com.csproj.CornerStore.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.csproj.CornerStore.entity.customerOrder;
import com.csproj.CornerStore.service.customerOrderService;

@RestController
@RequestMapping("/orders")
public class customerOrderController {

    private final customerOrderService orderService;

    public customerOrderController(customerOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<customerOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<customerOrder> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<customerOrder> getOrdersByCustomer(@PathVariable Integer customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    @PostMapping
    public customerOrder createOrder(@RequestBody customerOrder order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<customerOrder> updateOrder(@PathVariable Integer id, @RequestBody customerOrder order) {
        try {
            return ResponseEntity.ok(orderService.updateOrder(id, order));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}


