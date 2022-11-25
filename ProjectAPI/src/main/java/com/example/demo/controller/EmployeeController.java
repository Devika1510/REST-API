package com.example.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
private EmployeeService service;

public EmployeeController(EmployeeService service) {
	super();
	this.service = service;
}
//build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
    	return new ResponseEntity<Employee>(service.saveEmployee(employee),HttpStatus.CREATED);
    }
    
    //Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees(){
    	return service.getAllEmployees();
    }
    //build getEmployeeById REST API
    //http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
    	return new ResponseEntity<Employee>(service.getEmployeeByID(employeeId),HttpStatus.OK);
    }
    //build update 
    
    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,@RequestBody Employee employee){
    	return new  ResponseEntity<Employee>(service.updateEmployee(employee,employeeId),HttpStatus.OK);
    }
    
    //delete 
    @DeleteMapping("{id}")
    //http://localhost:8080/api/employees/1
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
    	service.deleteEmployee(employeeId);
    	return new ResponseEntity<String>("Employee deleted successfulyy",HttpStatus.OK);
    }
}
