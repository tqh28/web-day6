package com.example.webday6.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.webday6.entity.Student;
import com.example.webday6.repository.StudentRepository;

@Repository
public class StudentRepositoryJdbc implements StudentRepository {

	private JdbcTemplate jdbcTemplate;

	public StudentRepositoryJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Student s) {
		int update = jdbcTemplate.update("insert  into student (student_address, student_name) values (?, ?)",
				s.getAddress(), s.getName());
		System.out.println(update);
	}

}
