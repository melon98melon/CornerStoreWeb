package com.csproj.CornerStore.service;
import org.springframework.stereotype.Service;

import com.csproj.CornerStore.entity.customerOrder;
import com.csproj.CornerStore.repository.customerOrderRepo;

import java.util.List;
import java.util.Optional;

@Service
public class customerOrderService {

    private final customerOrderRepo orderRepository;

    public customerOrderService(customerOrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<customerOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<customerOrder> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public List<customerOrder> getOrdersByCustomerId(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public customerOrder createOrder(customerOrder order) {
        return orderRepository.save(order);
    }

    public customerOrder updateOrder(Integer id, customerOrder updatedOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setTotalAmount(updatedOrder.getTotalAmount());
                    order.setCustomer(updatedOrder.getCustomer());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
