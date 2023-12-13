package com.devsuperior.dscommerce.entities;

import com.devsuperior.dscommerce.projections.UserDetailsProjection;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"authority"})
@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String authority;

    public Role(UserDetailsProjection projection) {
        this.id = projection.getRoleId();
        this.authority = projection.getAuthority();
    }
}