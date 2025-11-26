package com.csproj.CornerStore.service;

import org.springframework.stereotype.Service;

import com.csproj.CornerStore.entity.orderItem;
import com.csproj.CornerStore.repository.orderItemRepo;

import java.util.List;
import java.util.Optional;

@Service
public class orderItemService {

    private final orderItemRepo orderItemRepository;

    public orderItemService(orderItemRepo orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<orderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<orderItem> getOrderItemById(Integer id) {
        return orderItemRepository.findById(id);
    }

    public List<orderItem> getOrderItemsByOrderId(Integer orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    public List<orderItem> getOrderItemsByProductId(Integer productId) {
        return orderItemRepository.findByProductId(productId);
    }

    public orderItem createOrderItem(orderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public orderItem updateOrderItem(Integer id, orderItem updatedOrderItem) {
        return orderItemRepository.findById(id)
                .map(orderItem -> {
                    orderItem.setOrder(updatedOrderItem.getOrder());
                    orderItem.setProduct(updatedOrderItem.getProduct());
                    orderItem.setQuantity(updatedOrderItem.getQuantity());
                    return orderItemRepository.save(orderItem);
                })
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
    }

    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }
}
