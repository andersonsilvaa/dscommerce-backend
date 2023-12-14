package com.devsuperior.dscommerce.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.devsuperior.dscommerce.dto.ProductDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String imgUrl;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public List<Order> getOrders() {
        return items.stream().map(x -> x.getOrder()).toList();
    }

    public Product(ProductDto dto) {
        new ModelMapper().map(dto, this);
        this.categories = dto.getCategories().stream().map(categoryDto ->
                new Category(categoryDto)).collect(Collectors.toSet());
    }

    public void dtoToEntity(ProductDto dto) {
        new ModelMapper().typeMap(ProductDto.class, Product.class)
                .addMappings(mapper -> mapper.skip(Product::setId))
                .map(dto, this);
        this.categories = dto.getCategories().stream().map(categoryDto ->
                new Category(categoryDto)).collect(Collectors.toSet());
    }
}
