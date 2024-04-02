package com.josphenmarya.empproject.Services;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josphenmarya.empproject.Entity.Address;
import com.josphenmarya.empproject.Entity.Employee;
import com.josphenmarya.empproject.Repository.AddressRepository;
import com.josphenmarya.empproject.Repository.EmployeeRepository;

@Service
public class EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressRepository addressRepository;
	

	public Employee createEmployee(Employee employee) {
		
		Employee newEmployee = employeeRepository.save(employee);

		for(Address address : newEmployee.getAddresses()) {

	        if(address.getEmployee() == null) {
	            address.setEmployee(newEmployee);
	            this.addressRepository.save(address);
	        }

		}
		return newEmployee;
		
	    }

	
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> existingEmployee =employeeRepository.findById(employee.getId());
		
		if (existingEmployee.isPresent()) {
            Employee emp = existingEmployee.get();
            
            emp.setName(employee.getName());
            emp.setEmailId(employee.getEmailId());
            emp.setPhoneNumber(employee.getPhoneNumber());
            return employeeRepository.save(emp);
        }
		else
		{
			throw new NoSuchElementException("Not Updated");
		}
	}


	public String deleteEmployee(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent())
		{
			employeeRepository.deleteById(id);
			return "Employee deleted successfully";
		}
		else {
			return "Employee Deletion Failed !";
		}
	}



	public Optional<Employee> getEmployee(int id) {
		return employeeRepository.findById(id);
	}


	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	

}
