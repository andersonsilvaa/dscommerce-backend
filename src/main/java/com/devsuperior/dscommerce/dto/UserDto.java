package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private List<String> roles = new ArrayList<String>();

    public UserDto(User user) {
        new ModelMapper().map(user, this);
        this.roles = user.getRoles().stream().map(userRole -> userRole.getAuthority()).toList();
    }
}
