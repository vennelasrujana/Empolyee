package com.crud.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.employee.Entity.Employee;
import com.crud.employee.Repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee data){
        employeeRepository.save(data);
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);;
    }

    public List<Employee> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        System.out.println("Employees: " + employees); 
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(long id){
        return employeeRepository.findById(id);
    }

}
