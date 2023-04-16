package com.nicotine.addiction.example.service;

import com.nicotine.addiction.example.dao.EmployeeDAO;
import com.nicotine.addiction.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO _employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        _employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return _employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return _employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return _employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        _employeeDAO.deleteById(id);
    }
}
