package com.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
private Map<Integer, Employee> empMap = new HashMap<>();
	
	//create
	@PostMapping
	public String createEmp(@RequestBody Employee emp) {

	    if (empMap.containsKey(emp.getId())) {
	        return "Employee already exists";
	    }

	    emp.setSalary(emp.getSalary());
	    empMap.put(emp.getId(), emp);

	    return "Employee created successfully";
	}

	
	//Read
	@GetMapping
	public Collection<Employee> getAllEmployees(){
		return empMap.values();
	}
	
	//Read by ID
	@GetMapping("/{id}")
	public Object getEmployee(@PathVariable int id) {

	    Employee emp = empMap.get(id);

	    if (emp == null) {
	        return "Employee not found";
	    }

	    return emp;
	}

	//PUT
	
	@PutMapping("/{id}")
	public Object updateEmployee(@PathVariable int id,@RequestBody Employee updatedEmp) {

	    Employee existing = empMap.get(id);

	    if (existing == null)
	        return "Employee not found";
	    //UPDATE

	    // Department cannot be changed
	    if (updatedEmp.getDepartment() != null &&
	        !Objects.equals(existing.getDepartment(), updatedEmp.getDepartment()))
	        return "Department cannot be changed";

	    // Designation change requires salary increase
	    if (updatedEmp.getDesignation() != null &&
	        !Objects.equals(existing.getDesignation(), updatedEmp.getDesignation()) &&
	        updatedEmp.getSalary() <= existing.getSalary())
	        return "Salary must increase to change designation";

	    // Update only provided fields
	    if (updatedEmp.getName() != null)
	        existing.setName(updatedEmp.getName());

	    if (updatedEmp.getDesignation() != null)
	        existing.setDesignation(updatedEmp.getDesignation());

	    if (updatedEmp.getSalary() > 0)
	        existing.setSalary(updatedEmp.getSalary());

	    return existing;
	}

	
	

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        getEmployee(id);
        empMap.remove(id);
        return "Employee deleted successfully";
    }
	
	
	}
	

	   

