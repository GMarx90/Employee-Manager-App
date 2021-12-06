package com.grzegorzmarx.employeemanager.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            nullable = false,
            updatable = false
    )
    private Long id;
    private String name;
    private String email;
    private String number;
    private String jobTitle;
    @Column(nullable = false,
            updatable = false)
    private String employeeCode;

}
