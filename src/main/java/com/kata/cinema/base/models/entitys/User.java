package com.kata.cinema.base.models.entitys;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "gen_user")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_user")
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    @Column(unique = true)
    private String login;

    @NotNull
    private String password;

    private LocalDate birthday;

    private String avatarUrl;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User(Long id, String email, String firstName, String lastName, String password, LocalDate birthday, String avatarUrl) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthday = birthday;
        this.avatarUrl = avatarUrl;
    }


    public User(String email, String firstName, String lastName, String password, LocalDate birthday, String avatarUrl, Set<Role> roles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthday = birthday;
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
