package com.josphenmarya.empproject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josphenmarya.empproject.Entity.Address;
import com.josphenmarya.empproject.Entity.Employee;
import com.josphenmarya.empproject.Repository.AddressRepository;
import com.josphenmarya.empproject.Repository.EmployeeRepository;

@Service
public class AddressService{

@Autowired
private AddressRepository addressRepository;
@Autowired
private EmployeeRepository employeeRepository;



public Address createAddress(Address address) {
	return addressRepository.save(address);
	
    }


public Address updateAddress(Address address) {
	
	Optional<Address> existingAddress = addressRepository.findById(address.getId());
	
	if (existingAddress.isPresent()) {
        Address add = existingAddress.get();
        
        add.setAddress(address.getAddress());
        
        return addressRepository.save(add);
    }
	else
	{
		return null;
	}
}


public String deleteAddress(int id) {
	Optional<Address> emp = addressRepository.findById(id);
	if(emp.isPresent())
	{
		addressRepository.deleteById(id);
		return "Address deleted successfully";
	}
	else {
		return "Address Deletion Failed !";
	}
}




public Optional<Address> getAddress(int id) {
	return addressRepository.findById(id);
}


public List<Address> getAllAddresses() {
	return addressRepository.findAll();
}



}
