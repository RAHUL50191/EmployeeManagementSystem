package com.ems.emsbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.emsbackend.dto.EmployeeDto;
import com.ems.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeservice;
	//Build add emp rest API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empDto){
		EmployeeDto savedEmployee=employeeservice.createEmployee(empDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	//Build Get Employee REST API
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long empId) {
		EmployeeDto empDto=employeeservice.getEmployeeById(empId);
		return ResponseEntity.ok(empDto);
	}
	//Build Get All Employees REST API
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> allEmp=employeeservice.getAllEmployees();
		return ResponseEntity.ok( allEmp);
	}
	//Build update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> postMethodName(@PathVariable("id") Long empId,@RequestBody EmployeeDto updatedEmployee) {
		//TODO: process POST request
		EmployeeDto uemp=employeeservice.updateEmployee(empId, updatedEmployee);
		return ResponseEntity.ok(uemp);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> getMethodName(@PathVariable("id") Long empId) {
		employeeservice.deleteEmployee(empId);
		return ResponseEntity.ok("Deleted employee");
	}
	

}
