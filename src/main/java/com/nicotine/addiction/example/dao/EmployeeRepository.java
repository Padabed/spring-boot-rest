package com.nicotine.addiction.example.dao;

import com.nicotine.addiction.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
