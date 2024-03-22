package com.mkpit.assig1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpit.assig1.entity.Employee;
import com.mkpit.assig1.repository.EmployeeRepository;

@Service
public class EmployeeService {
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    public Employee createEmployee(Employee employee) {
	        employee.setDoj(new Date()); // Set date of joining
	        return employeeRepository.save(employee);
	    }

	    public Employee getEmployeeById(Long id) {
	        return employeeRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	    }

	    public Employee updateEmployee(Long id, Employee employeeDetails) {
	        Employee employee = getEmployeeById(id);
	        employee.setName(employeeDetails.getName());
	        employee.setDept(employeeDetails.getDept());
	        // Set other fields as needed
	        return employeeRepository.save(employee);
	    }

	    public void deleteEmployee(Long id) {
	        Employee employee = getEmployeeById(id);
	        employeeRepository.delete(employee);
	    }

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public List<Employee> searchEmployees(String keyword) {
	        if (keyword != null) {
	            return employeeRepository.findByNameContainingIgnoreCaseOrDeptContainingIgnoreCase(keyword, keyword);
	        }
	        return getAllEmployees();
	    }
}
