package com.example.webday6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webday6.entity.Student;
import com.example.webday6.rest.model.CreateStudentRequest;
import com.example.webday6.rest.transform.CreateStudentTransform;
import com.example.webday6.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public String insert(@RequestBody CreateStudentRequest requestBody) {
		CreateStudentTransform transform = new CreateStudentTransform();
		Student student = transform.apply(requestBody);
		studentService.insert(student);
		return "Create new student success";
	}
}
