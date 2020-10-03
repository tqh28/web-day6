package com.example.webday6.rest.transform;

import com.example.webday6.entity.Student;
import com.example.webday6.rest.model.CreateStudentRequest;

public class CreateStudentTransform {

	public Student apply(CreateStudentRequest body) {
		Student s = new Student();
		s.setName(body.getName());
		s.setAddress(body.getAddress());

		return s;
	}
}
