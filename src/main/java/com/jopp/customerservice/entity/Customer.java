package com.jopp.customerservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "Full_Name", length = 64, nullable = false)
    private String fullName;

    @NotNull
    @Column(name = "Date_Of_Birth", length = 64, nullable = false)
    private String dateOfBirth;

    @NotNull
    @Column(name = "Username", length = 64, nullable = false)
    private String username;

    @NotNull
    @Column(name = "Password", length = 64, nullable = false)
    private String password;

    public Customer(String fullName, String dateOfBirth, String username, String password) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }
}
