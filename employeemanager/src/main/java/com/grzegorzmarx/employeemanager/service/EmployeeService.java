package com.grzegorzmarx.employeemanager.service;

import com.grzegorzmarx.employeemanager.exception.UserNotFoundException;
import com.grzegorzmarx.employeemanager.model.Employee;
import com.grzegorzmarx.employeemanager.respository.EmployeeRepo;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
       return employeeRepo.save(employee);
    }
    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee (Employee employee){
            return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);

    }
    public Employee findEmployeeByID(Long id){
        return employeeRepo.findEmployeeById( id).orElseThrow(()-> new UserNotFoundException("Employee with id: "+id+" doesn't exist"));

    }
}
