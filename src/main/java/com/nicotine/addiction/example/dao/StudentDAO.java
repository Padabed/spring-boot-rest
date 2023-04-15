package com.nicotine.addiction.example.dao;

import com.nicotine.addiction.example.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void removeAll();

    void delete(int id);
}
