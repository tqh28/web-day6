package com.example.webday6.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday6.entity.Student;
import com.example.webday6.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private EntityManager em;

	@Autowired
	public StudentRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Student s) {
		em.persist(s);
	}

}
