package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Payment;
import com.devsuperior.dscommerce.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Long id;
    private Instant moment;

    public PaymentDto(Payment payment) {
        new ModelMapper().map(payment, this);
    }
}
