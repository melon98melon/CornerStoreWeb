package com.csproj.CornerStore.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.csproj.CornerStore.entity.orderItem;
import com.csproj.CornerStore.service.orderItemService;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
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
    public ResponseEntity<orderItem> getOrderItemById(@PathVariable Integer id) {
        return orderItemService.getOrderItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/order/{orderId}")
    public List<orderItem> getOrderItemsByOrder(@PathVariable Integer orderId) {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }

    @GetMapping("/product/{productId}")
    public List<orderItem> getOrderItemsByProduct(@PathVariable Integer productId) {
        return orderItemService.getOrderItemsByProductId(productId);
    }

    @PostMapping
    public orderItem createOrderItem(@RequestBody orderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<orderItem> updateOrderItem(@PathVariable Integer id, @RequestBody orderItem orderItem) {
        try {
            return ResponseEntity.ok(orderItemService.updateOrderItem(id, orderItem));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Integer id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
