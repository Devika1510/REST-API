package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	public EmployeeImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository=employeeRepository;
	}
	
	
	
	@Override
    public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
    	
    }


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeByID(long id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			return null;
			//throw new Exception("Employee","Id",id);
	}
		
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//first check whether it is present
		Employee existing=employeeRepository.findById(id).orElseThrow(() -> null);
		existing.setFirstName(employee.getFirstName());
		existing.setLastname(employee.getLastname());
		existing.setEmail(employee.getEmail());

		employeeRepository.save(existing);
		return null;
	}



	@Override
	public void deleteEmployee(long id) {
		//check existing
		employeeRepository.findById(id).orElseThrow(() -> null);
		employeeRepository.deleteById(id);
		
	}
		
}
