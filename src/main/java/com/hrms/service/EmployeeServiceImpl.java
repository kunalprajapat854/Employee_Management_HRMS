package com.hrms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hrms.entities.Employee;
import com.hrms.repository.core.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public boolean createEmp(Employee employee) {
		Employee save = employeeRepository.save(employee);
		return save != null;
	}

	public boolean updateEmp(Employee employee) {
		if (employee == null && employee.getEmployeeId() == null) {
			return false;
		}
		Optional<Employee> existingEmp = employeeRepository.findById(employee.getEmployeeId());
		if (existingEmp.isPresent()) {
			Employee updatedEmp = employeeRepository.save(employee);
			return updatedEmp != null;
		}
		return false;

	}

	@Override
	public Employee getByEmpId(Long id) {
		Optional<Employee> byId = employeeRepository.findById(id);
		if (byId.isPresent()) {
			byId.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
