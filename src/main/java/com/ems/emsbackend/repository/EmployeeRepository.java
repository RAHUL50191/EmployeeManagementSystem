package com.ems.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.emsbackend.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
