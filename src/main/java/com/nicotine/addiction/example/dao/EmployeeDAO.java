package com.nicotine.addiction.example.dao;

import com.nicotine.addiction.example.entity.Employee;
import com.nicotine.addiction.example.service.EmployeeService;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
