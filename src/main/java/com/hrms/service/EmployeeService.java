package com.hrms.service;

import java.util.List;

import com.hrms.entities.Employee;

public interface EmployeeService {

	public boolean createEmp(Employee employee);

	public boolean updateEmp(Employee employee);

	public Employee getByEmpId(Long id);

	public List<Employee> getAllEmployees();

}
