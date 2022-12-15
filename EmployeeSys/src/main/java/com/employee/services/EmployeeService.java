package com.employee.services;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository emRepository;
	
	
	public List<Employee> getAllEmp(){
		
		List<Employee> list = (List<Employee>) emRepository.findAll();
		System.out.println(list);
		return list;
	}
	
	
	public Employee getEMpById(int empid) {
		Employee e = emRepository.findById(empid);
		if (e!=null) {
			return e;
		}
		return null;
	}
	
	
	
	public Employee addEmp(Employee emp) {
		
		Employee em=emRepository.save(emp);
		return em;
		

	}
	
	public void deleteEMp(int empid) {
		emRepository.deleteById(empid);
	}

//	public Page<Employee> getEMpByPaginate(int currentPage, int size) {
//		Page p =(Page) PageRequest.of(currentPage, size);
//		return emRepository.findAll(p);
//	}
}
