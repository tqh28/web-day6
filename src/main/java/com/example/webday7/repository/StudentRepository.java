package com.example.webday7.repository;

import java.util.List;

import com.example.webday7.entity.Student;

public interface StudentRepository {

	List<Student> findAll();

	Student findById(long id);

	void insert(Student s);

	void update(Student s);

	void delete(Student s);

}
