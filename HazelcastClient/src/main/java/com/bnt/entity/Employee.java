package com.bnt.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Employee implements Serializable {
    private Long id;
    private String name;
    private String department;
}
