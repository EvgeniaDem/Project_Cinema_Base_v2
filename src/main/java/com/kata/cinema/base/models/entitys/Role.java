package com.kata.cinema.base.models.entitys;


import com.kata.cinema.base.models.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;


@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @SequenceGenerator(name = "gen_role")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_role")
    private Long id;

    public Role(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(unique = true)
    private Roles name;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
