package com.devsuperior.dscommerce.services;


import com.devsuperior.dscommerce.dto.OrderDto;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDto(order);
    }
}
