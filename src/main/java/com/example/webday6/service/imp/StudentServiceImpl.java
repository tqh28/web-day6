package com.example.webday6.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webday6.entity.Student;
import com.example.webday6.repository.StudentRepository;
import com.example.webday6.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepositoryImpl) {
		this.studentRepository = studentRepositoryImpl;
	}

	@Override
	@Transactional
	public void insert(Student s) {
		studentRepository.insert(s);
	}

}
