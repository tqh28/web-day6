package com.example.webday6.service.imp;

import java.util.List;

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
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(long id) {
		return studentRepository.findById(id);
	}

	@Override
	@Transactional
	public void insert(Student s) {
		studentRepository.insert(s);
	}

	@Override
	@Transactional
	public void update(Student s) {
		studentRepository.update(s);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Student s = studentRepository.findById(id);
		studentRepository.delete(s);
	}

}
