package com.josphenmarya.empproject.Controllers;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josphenmarya.empproject.Entity.Employee;
import com.josphenmarya.empproject.Services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	EmployeeService employeeService;
	
	
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@PostMapping("/")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		Employee emp= this.employeeService.createEmployee(employee);
		return ResponseEntity.ok().body(emp);
		
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee employee)
	{
		Employee emp= this.employeeService.updateEmployee(employee);
		return ResponseEntity.ok().body(emp); 
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		String result = this.employeeService.deleteEmployee(id);
		return ResponseEntity.ok().body(result); 
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id)
	{
		
		Optional<Employee> emp= this.employeeService.getEmployee(id);
		if(emp.isPresent())
		{
			return ResponseEntity.ok().body(emp); 
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Employee Found");
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllEmployees()
	{
		List<Employee> listEmployees=employeeService.getAllEmployees();
		return  ResponseEntity.ok().body(listEmployees);
	}
	

	
}
