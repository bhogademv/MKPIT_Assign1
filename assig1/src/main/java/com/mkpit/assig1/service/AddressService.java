package com.mkpit.assig1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpit.assig1.DTO.AddressDTO;
import com.mkpit.assig1.DTO.EmployeeDTO;
import com.mkpit.assig1.entity.Address;
import com.mkpit.assig1.entity.Employee;
import com.mkpit.assig1.repository.AddressRepository;
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper; 

    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = convertToEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return convertToDTO(savedAddress);
    }

    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        Address existingAddress =addressRepository.findById(id).orElse(null);
        existingAddress.setStreet(addressDTO.getStreet());
        existingAddress.setCity(addressDTO.getCity());
        existingAddress.setState(addressDTO.getState());
        existingAddress.setPostalCode(addressDTO.getPostalCode());
        // Update other fields as needed
        Address updatedAddress = addressRepository.save(existingAddress);
        return convertToDTO(updatedAddress);
    }

    public void deleteAddress(Long id) {
        AddressDTO address = getAddressById(id);
        addressRepository.deleteById(address.getId());
    }

    public List<AddressDTO> getAddressesByEmployeeId(Long employeeId) {
        List<Address> addresses = addressRepository.findByEmployeeId(employeeId);
        return addresses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AddressDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        return convertToDTO(address);
    }

    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AddressDTO convertToDTO(Address address) {
        AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
        Employee employee = address.getEmployee();
        if (employee != null) {
            addressDTO.getEmployee().setName(employee.getName());
            addressDTO.getEmployee().setDept(employee.getDept());
            addressDTO.getEmployee().setDoj(employee.getDoj());
        }
        return addressDTO;
    }

    private Address convertToEntity(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address.setEmployee(convertToEntity(addressDTO.getEmployee()));
        return address;
    }

    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}