package com.model;

public class Employee {
	
	    private int id;
	    private String name;
	    private String department;
	    private String designation;
	    private double salary;
	    private String salaryBand;

	    public Employee() {}

	    public Employee(int id, String name, String department,
	                    String designation, double salary) {
	        this.id = id;
	        this.name = name;
	        this.department = department;
	        this.designation = designation;
	        this.salary = salary;
	        setSalary(salary);
	    }

	    private String calculateSalaryBand(double salary) {
	        if (salary < 30000)
	        	return "LOW";
	        else if(salary <= 70000)
	        	return "MEDIUM";
	        else 
	        	return "HIGH";
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	        this.salaryBand = calculateSalaryBand(salary);
	    }

	    
	    public int getId() { 
	    	return id;
	    	}
	    public void setId(int id) {
	    	this.id = id;
	    	}

	    public String getName() {
	    	return name;
	    	}
	    public void setName(String name) {
	    	this.name = name;
	    	}

	    public String getDepartment() {
	    	return department; 
	    	}

	    public String getDesignation() {
	    	return designation;
	    	}
	    public void setDesignation(String designation) { 
	    	this.designation = designation; 
	    	}

	    public double getSalary() { 
	    	return salary; 
	    	}
	    public String getSalaryBand() { 
	    	return salaryBand; 
	    	}
	}


