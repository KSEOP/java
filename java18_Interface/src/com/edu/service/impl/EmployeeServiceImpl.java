package com.edu.service.impl;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	//1 -- 싱글톤 --
	static private EmployeeServiceImpl service
	=new EmployeeServiceImpl();
	
	//2
	private EmployeeServiceImpl() {
		System.out.println("Client Request Ready...");
	}
	
	//3
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	


	@Override
	public void printAllEmployee(Employee[] emps) {
		for(Employee e:emps) {
			System.out.println(e);}
		
	}

	@Override
	public Employee findEmployee(Employee[] emps, String name) {
		Employee employee = null;
		for(Employee e:emps) {
			if(e.getName().equals(name)) {
				employee = e;
				break; //name이 unique 하다는 가정 하임.
			}
		}
		
		
		return employee;
	}

	@Override
	public Employee[] findEmployeeByDept(Employee[] emps, String dept) {
		Employee[] temp = new Employee[emps.length];
		int idx = 0;
		for(Employee e : emps) {
			if(e instanceof Manager) {
				if(((Manager) e).getDept().equals(dept)) { // object casting
					temp[idx++] = e;
				}
			}
		}
		return temp;
	}

	@Override
	public double getAnnualSalary(Employee e) {
		double annualSalary = 0;
		if(e instanceof Engineer) annualSalary = e.getSalary()*12 + ((Engineer) e).getBonus();
		
		return annualSalary;
	}

	@Override
	public double getTotalCost(Employee[] ea) {
		double total = 0;
		for(Employee e : ea)
			getAnnualSalary(e);
		
		return total;		
	}
	
	

}
