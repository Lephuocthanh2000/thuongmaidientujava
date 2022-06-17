package com.ThanhLe.thuongmaidientu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    Integer id;
    @NotEmpty
    String username;
    @NotEmpty
    @Length(min=6)
    String password;
    @NotEmpty
    String fullname;
    @NotEmpty
    @Length(min=10)
    String phone;
    @NotEmpty
    @Email
    String email;
    @NotEmpty
    String address;
    String photo;
    Boolean activated;
    Boolean admin;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    List<Order> orders;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
