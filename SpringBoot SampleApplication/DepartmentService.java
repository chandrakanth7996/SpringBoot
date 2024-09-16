package com.example.springbootExample.springboot.Service;

import java.util.List;

import com.example.springbootExample.springboot.Entity.DepartmentEntity;

public interface DepartmentService {

    public DepartmentEntity saveDepartment(DepartmentEntity department);

	public List<DepartmentEntity> fetchDetails();

	public DepartmentEntity fetchDataById(Long id);

	public void deleteDepartmentById(Long id);

	public DepartmentEntity updateDepartment(Long id, DepartmentEntity department);

	public DepartmentEntity fetchDataByName(String name);

}
