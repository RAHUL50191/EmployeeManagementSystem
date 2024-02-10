package com.ems.emsbackend.service;

import java.util.List;

import com.ems.emsbackend.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto empDto);

	EmployeeDto getEmployeeById(Long empId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long empId, EmployeeDto updatedEmployee);

	void deleteEmployee(Long empId);
	
}
