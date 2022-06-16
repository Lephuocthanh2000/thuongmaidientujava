package com.ThanhLe.thuongmaidientu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="employee_profile")
@Getter
@Setter

public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
