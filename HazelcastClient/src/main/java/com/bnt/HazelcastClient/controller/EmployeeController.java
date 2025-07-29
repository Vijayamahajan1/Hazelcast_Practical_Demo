package com.bnt.HazelcastClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bnt.entity.Employee;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    HazelcastInstance hazelcastInstance;

    private IMap<Long, Employee> getEmployeeMap() {
        return hazelcastInstance.getMap("employeeMap");
    }
    
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        IMap<Long,Employee> employeeMap = hazelcastInstance.getMap("employeeMap");
        employeeMap.set(employee.getId(), employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee emp = getEmployeeMap().get(id);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = new ArrayList<>(getEmployeeMap().values());
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Employee removed = getEmployeeMap().remove(id);
        if (removed != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
