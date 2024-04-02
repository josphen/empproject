package com.josphenmarya.empproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josphenmarya.empproject.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
