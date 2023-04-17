package com.nicotine.addiction.example.dao;

import com.nicotine.addiction.example.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager _entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        _entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return _entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query =
                _entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query =
                _entityManager.createQuery("select s from Student s where s.lastName=:data", Student.class);
        query.setParameter("data", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        _entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = _entityManager.find(Student.class, id);
        _entityManager.remove(student);
    }

    @Override
    @Transactional
    public void removeAll() {
        _entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

}
