package com.bnt.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
    @Id
    private Long id;
    private String name;
    private String department;
}
