package com.nicotine.addiction.example.dao;

import com.nicotine.addiction.example.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager _entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query =
                _entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return _entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return _entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        _entityManager.remove(findById(id));
    }
}
