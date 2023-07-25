package com.self.service.impl;

import com.self.service.EmployeeService;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {

	// 1 -- 싱글톤 --
	static private EmployeeServiceImpl service = new EmployeeServiceImpl();

	// 2 -- 싱글톤 --
	ArrayList<Employee> emps;
	public static final int MAX_CUSTOMERS = 100;

	public EmployeeServiceImpl() {
		emps = new ArrayList<Employee>(MAX_CUSTOMERS);
	}

	// 3 -- 싱글톤 --
	public static EmployeeServiceImpl getInstance() {
		return service;
	}

	// 직원 등록
	@Override
	public void addEmployee(Employee e) {
		emps.add(e);
		return;
	}

	// 직원 삭제
	@Override
	public void deleteEmployee(String name) {
		for (Employee p : emps) {
			if (p.equals(name)) {
				emps.remove(p);
			}
		}
	}

	// 직원 상세정보 수정(manager)
	@Override
	public void updateEmployee(double salary, String dept, int deptno, String name) {
		for (Employee e : emps) {
			if (e != null && e instanceof Manager) {
				if (e.getName().equals(name)) {
					e.changeSalary(salary);
					((Manager) e).setDept(dept);
					((Manager) e).setDeptno(deptno);
				}
			}
		}
	}

	// 직원 상세정보 수정(engineer)
	@Override
	public void updateEmployee(double salary, String tech, double bonus, String name) {
		for (Employee e : emps) {
			if (e != null && e instanceof Engineer) {
				if (e.getName().equals(name)) {
					e.changeSalary(salary);
					((Engineer) e).changeTech(tech);
					((Engineer) e).changeBonus(bonus);
				}
			}
		}

	}

	// 이름으로 특정 직원 찾기
	@Override
	public Employee findEmployeeByName(String name) {
		Employee employee = null;
		for (Employee e : emps) {
			if (e == null)
				continue;
			if (e.getName().equals(name)) {
				employee = e;
				break;
			}
		}
		return employee;
	}

	// 같은 부서 내 직원들 찾기
	@Override
	public ArrayList<Employee> findEmployeeByDeptNo(int deptno) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		for (Employee e : emps) {
			if (e == null)
				continue;
			if (e instanceof Manager) {
				if (((Manager) e).getDeptno() == deptno) {
					temp.add(e);
				}
			}
		}
		return temp;
	}

	// 같은 기술을 보유한 직원들 찾기
	@Override
	public ArrayList<Employee> findEmployeeByTech(String tech) {
		ArrayList<Employee> temp = new ArrayList<>();
		for (Employee e : emps) {
			if (e == null)
				continue;
			if (e instanceof Engineer) {
				if (((Engineer) e).getTech().equalsIgnoreCase(tech)) {
					temp.add(e);
				}

			}
		}
		return temp;
	}

	// 특정 직원 연봉 검색
	@Override
	public double getAnnualSalary(String name) {
		double annualSalary = 0.0;
		for (Employee e : emps) {
			if (e == null)
				continue;
			if (e.getName().equals(name)) {
				annualSalary = e.getSalary() * 12;
				if (e instanceof Engineer)
					annualSalary += ((Engineer) e).getBonus();
			}
		}
		return annualSalary;
	}

	// 특정 연봉 이상의 사람들을 검색
	@Override
	public ArrayList<Employee> getAnnualSalaryMoreThan(double salary) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		double annualSalary = 0.0;
		for (Employee e : emps) {
			if (e == null)
				continue;
			annualSalary = getAnnualSalary(e.getName());
			if (annualSalary >= salary)
				temp.add(e);
		}
		return temp;
	}

	// print 관련
	@Override
	public void printAllEmployees() {
		for (Employee e : emps) {
			if (e != null)
				System.out.println(e);
		}
	}

	@Override
	public void printManagers() {
		for (Employee e : emps) {
			if (e != null && e instanceof Manager)
				System.out.println(e);
		}

	}

	@Override
	public void printEngineers() {
		for (Employee e : emps) {
			if (e != null && e instanceof Engineer)
				System.out.println(e);
		}

	}
}
