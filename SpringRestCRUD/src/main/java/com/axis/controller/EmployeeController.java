package com.axis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dao.EmployeeDao;
import com.axis.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao emprepo;
	@GetMapping("/greet")
	public String greet() {
		return "hello jpa";
	}
	
	//adding employee
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee){
		emprepo.save(new Employee(employee.getId(),employee.getName(),employee.getDept(),employee.getAge()));
		return employee;	
	}
	
	//getting all employees
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return emprepo.findAll();
	}
	
	//update employee
	@PutMapping("/updateEmp/{id}")
	public String updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
		Optional<Employee> result=emprepo.findById(id);
		if(result.isPresent()) {
			Employee emp=result.get();
			emp.setId(employee.getId());
			emp.setName(employee.getName());
			emp.setDept(employee.getDept());
			emp.setAge(employee.getAge());
			emprepo.save(emp);	
		}
		return "updated successfully";
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		emprepo.deleteById(id);
		return "deleted successfull";
	}
	

}
