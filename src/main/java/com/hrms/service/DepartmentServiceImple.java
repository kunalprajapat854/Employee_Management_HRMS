package com.hrms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.hrms.entities.Department;
import com.hrms.entities.Employee;
import com.hrms.repository.core.DepartmentRepository;
import com.hrms.repository.core.EmployeeRepository;

@Service
public class DepartmentServiceImple implements DepartmentService {

	private DepartmentRepository departmentRepository;

	private EmployeeRepository employeeRepository;

	public DepartmentServiceImple(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public boolean createDepartment(Department department) {
		Department save = departmentRepository.save(department);
		return save != null;

	}

	public void assignEmployeeToDepartment(Long empId, Long deptId) {
		Optional<Employee> employeeId = employeeRepository.findById(empId);
		Optional<Department> departId = departmentRepository.findById(deptId);

		if (employeeId.isPresent() && departId.isPresent()) {
			Employee employee = employeeId.get();
			Department department = departId.get();

			employee.setDepartment(department);
			employeeRepository.save(employee);
		} else {
			throw new RuntimeException("Invalid employeeId and departmentIdw");
		}

	}

	public Department getByDeptId(Long deptId) {
		Optional<Department> byId = departmentRepository.findById(deptId);
		if (byId.isPresent()) {
			byId.get();
		}
		return null;
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

}
