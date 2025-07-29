package com.bnt.mapstore;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.bnt.entity.Employee;
import com.bnt.repository.EmployeeRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.map.MapStore;

@Slf4j
@Component
public class EmployeeMapstore implements MapStore<Long , Employee>{

    @Autowired
    @Lazy
    EmployeeRepo employeeRepo;

    @Override
    public Iterable<Long> loadAllKeys() {
        log.info("loadAllKeys method called");
     return  employeeRepo.findAll().stream().map(Employee::getId).collect(Collectors.toList());
    }

    @Override
    public void delete(Long key) {
        log.info("Deleting employee with key " + key);
        employeeRepo.deleteById(key);
    }

    @Override
    public void deleteAll(Collection<Long> keys) {
        log.info("Deleting all employees from the mapstore");
        employeeRepo.deleteAllById(keys);
    }

    @Override
    public Employee load(Long key) {
        log.info("Loading employee " + key);
   return employeeRepo.findById(key).orElse(null);
    }

    @Override
    public Map<Long, Employee> loadAll(Collection<Long> keys) {
        log.info("loadAll method called");
      return employeeRepo.findAllById(keys).stream().collect(Collectors.toMap(Employee::getId,emp->emp ));
    }

    @Override
    public void store(Long key, Employee value) {
        log.info("Storing employee " + key + " with value " + value);
        employeeRepo.save(value);
    }

    @Override
    public void storeAll(Map<Long, Employee> map) {
        log.info("Store All method called");
        employeeRepo.saveAll(map.values());
    }
    
}
