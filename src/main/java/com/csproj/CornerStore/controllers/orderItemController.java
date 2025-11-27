package com.csproj.CornerStore.controllers;

import org.springframework.web.bind.annotation.*;

import com.csproj.CornerStore.entity.orderItem;
import com.csproj.CornerStore.service.orderItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderItems")
public class orderItemController {

    private final orderItemService orderItemService;

    public orderItemController(orderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public List<orderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public Optional<orderItem> getOrderItemById(@PathVariable int id) {
        return orderItemService.getOrderItemById(id);
    }

    @PostMapping
    public orderItem createOrderItem(@RequestBody orderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteOrderItem(id);
    }
}
