package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@Getter
@Setter
public class ProductMinDto {

    private Long id;

    private String name;

    private Double price;

    private String imgUrl;

    public ProductMinDto(Product product) {
        new ModelMapper().map(product, this);
    }
}
