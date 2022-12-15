package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	public Employee findById(int empid);
	public Employee deleteById(int empid);
}
