package com.crud.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.employee.Entity.Employee;




public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee findFirstByEmail(String email);
}
