package com.josphenmarya.empproject.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josphenmarya.empproject.Entity.Address;
import com.josphenmarya.empproject.Entity.Employee;
import com.josphenmarya.empproject.Services.AddressService;
import com.josphenmarya.empproject.Services.EmployeeService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> createAddress(@RequestBody Address address) {
		Address add= this.addressService.createAddress(address);
		return ResponseEntity.ok().body(add);
		
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> updateAddress(@PathVariable int id, @RequestBody Address address)
	{
		Address add= this.addressService.createAddress(address);
		return ResponseEntity.ok().body(add); 
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable int id) {
		String result = this.addressService.deleteAddress(id);
		return ResponseEntity.ok().body(result); 
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAddress(@PathVariable int id)
	{
		
		Optional<Address> add= this.addressService.getAddress(id);
		if(add.isPresent())
		{
			return ResponseEntity.ok().body(add); 
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Address Found");
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllAddresses()
	{
		List<Address> listEmployees=addressService.getAllAddresses();
		return  ResponseEntity.ok().body(listEmployees);
	}
	
	

}
