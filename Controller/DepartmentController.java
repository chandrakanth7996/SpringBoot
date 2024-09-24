package com.example.springbootExample.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootExample.springboot.Entity.DepartmentEntity;
import com.example.springbootExample.springboot.Exception.DepartmentNotFoundException;
import com.example.springbootExample.springboot.Service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/get")
	public List<DepartmentEntity> fetchDetails(){
		return departmentService.fetchDetails();
	}
	
	@GetMapping("/department/{id}")
	public DepartmentEntity fetchDataById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
		return departmentService.fetchDataById(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id) {
		departmentService.deleteDepartmentById(id);
		return "Successfully deleted!!!";
	}
	
	@PutMapping("/departments/{id}")
	public DepartmentEntity updateDepartment(@PathVariable("id") Long id,
			@RequestBody DepartmentEntity department) {
		return departmentService.updateDepartment(id,department);
	}
	
	@GetMapping("/departments/{name}")
	public DepartmentEntity fetchDataByName(@PathVariable("name") String name) {
		return departmentService.fetchDataByName(name);
	}

}
