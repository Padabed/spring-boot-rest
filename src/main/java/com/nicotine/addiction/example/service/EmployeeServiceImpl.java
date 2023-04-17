package com.nicotine.addiction.example.service;

import com.nicotine.addiction.example.dao.EmployeeRepository;
import com.nicotine.addiction.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository _employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        _employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return _employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = _employeeRepository.findById(id);
        Employee employee;

        if(result.isEmpty()) {
            throw new IllegalArgumentException("Employee with id: " + id + " not found");
        }

        employee = result.get();

        return  employee;
    }

    @Override
    public Employee save(Employee employee) {
        return _employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        _employeeRepository.deleteById(id);
    }
}
