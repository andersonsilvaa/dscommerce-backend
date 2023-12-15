package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private String name;

    public ClientDto(User user) {
        new ModelMapper().map(user, this);
    }
}
