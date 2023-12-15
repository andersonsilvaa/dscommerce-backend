package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientDto client;
    private PaymentDto payment;

    @NotEmpty(message = "Deve ter pelo menos um item")
    private List<OrderItemDto> items = new ArrayList<OrderItemDto>();

    public OrderDto(Order order) {
        new ModelMapper().map(order, this);
        this.client = new ClientDto(order.getClient());
        this.payment = (order.getPayment() == null) ? null : new PaymentDto(order.getPayment());
        this.items = order.getItems().stream().map(item -> new OrderItemDto(item)).toList();
    }

    public Double getTotal() {
        return this.items.stream().reduce(0.0, (soma, item) -> soma + item.getSubTotal(), Double::sum);
    }
}
