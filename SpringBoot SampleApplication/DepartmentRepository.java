package com.example.springbootExample.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootExample.springboot.Entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long>{
	
	public DepartmentEntity findByName(String name);
	
	public DepartmentEntity findByNameEqualsIgnoreCase(String name);

}
