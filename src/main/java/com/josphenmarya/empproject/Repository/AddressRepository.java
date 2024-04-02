package com.josphenmarya.empproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josphenmarya.empproject.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
