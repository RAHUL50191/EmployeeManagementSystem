package com.ems.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.emsbackend.dto.EmployeeDto;
import com.ems.emsbackend.entity.Employee;
import com.ems.emsbackend.exception.ResourceNotFoundException;
import com.ems.emsbackend.mapper.EmployeeMapper;
import com.ems.emsbackend.repository.EmployeeRepository;
import com.ems.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto) {
		// TODO Auto-generated method stub
		Employee emp=EmployeeMapper.mapToEmployee(empDto);
		Employee saveedEmployee=employeeRepository.save(emp);
		return EmployeeMapper.mapToEmployeeDto(saveedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeById(Long empId) {
		Employee foundEmployee =employeeRepository.findById(empId)
		.orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id:"+empId));
		return EmployeeMapper.mapToEmployeeDto(foundEmployee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees(){
		List<Employee> allEmployees=employeeRepository.findAll();
		return allEmployees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
		
	}
	@Override
	public EmployeeDto updateEmployee(Long empId,EmployeeDto updatedEmp) {
		//check if emp exists
		Employee foundEmployee =employeeRepository.findById(empId)
				.orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id:"+empId));
	    foundEmployee.setFirstName(updatedEmp.getFirstName());
	    foundEmployee.setLastName(updatedEmp.getLastName());
	    foundEmployee.setEmail(updatedEmp.getEmail());
		
	    Employee updatedEmployee=employeeRepository.save(foundEmployee);
	    System.out.println("foundEmployee==updatedEmployee"+(foundEmployee==updatedEmployee));
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	
	}@Override
	public void deleteEmployee(Long empId) {
		Employee foundEmployee =employeeRepository.findById(empId)
				.orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id:"+empId));
//		employeeRepository.delete(foundEmployee);
		employeeRepository.deleteById(empId);
		return;
	}
	

}
