package com.hrms.service;

import java.util.List;

import com.hrms.entities.Department;

public interface DepartmentService {

	public boolean createDepartment(Department department);

	public void assignEmployeeToDepartment(Long empId, Long deptId);

	public Department getByDeptId(Long deptId);

	public List<Department> getAllDepartments();

}
