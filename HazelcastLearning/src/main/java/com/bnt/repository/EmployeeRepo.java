package com.bnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnt.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee , Long>{

}
