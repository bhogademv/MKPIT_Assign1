package com.mkpit.assig1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkpit.assig1.DTO.AddressDTO;
import com.mkpit.assig1.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	 List<Address> findByEmployeeId(Long employeeId);

	Address save(AddressDTO existingAddress);
}
