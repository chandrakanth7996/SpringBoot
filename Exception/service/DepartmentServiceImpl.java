package com.example.springbootExample.springboot.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootExample.springboot.Entity.DepartmentEntity;
import com.example.springbootExample.springboot.Exception.DepartmentNotFoundException;
import com.example.springbootExample.springboot.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentEntity saveDepartment(DepartmentEntity department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<DepartmentEntity> fetchDetails() {
		return departmentRepository.findAll();
	}

	@Override
	public DepartmentEntity fetchDataById(Long id) throws DepartmentNotFoundException {
		Optional<DepartmentEntity> dept = departmentRepository.findById(id);
		if(!dept.isPresent()) {
			throw new DepartmentNotFoundException("This " + id+  " id is not available");
		}
		return dept.get();
	}

	@Override
	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public DepartmentEntity updateDepartment(Long id, DepartmentEntity department) {
		DepartmentEntity deptDB = departmentRepository.findById(id).get();
		if(Objects.nonNull(department.getName()) && 
				!"".equalsIgnoreCase(department.getName())) {
			deptDB.setName(department.getName());
		}
		if(Objects.nonNull(department.getCode()) && 
				!"".equalsIgnoreCase(department.getCode())) {
			deptDB.setCode(department.getCode());
		}
		if(Objects.nonNull(department.getAddress()) && 
				!"".equalsIgnoreCase(department.getAddress())) {
			deptDB.setAddress(department.getAddress());
		}
		return departmentRepository.save(deptDB);
	}

	@Override
	public DepartmentEntity fetchDataByName(String name) {
		return departmentRepository.findByNameEqualsIgnoreCase(name);
	}
	

}
