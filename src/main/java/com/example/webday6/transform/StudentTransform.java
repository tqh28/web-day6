package com.example.webday6.transform;

import java.text.DateFormat;
import java.text.ParseException;

import com.example.webday6.dto.CreateStudentDTO;
import com.example.webday6.dto.UpdateStudentDTO;
import com.example.webday6.entity.Student;

public class StudentTransform {

	private DateFormat dateFormat;

	public StudentTransform(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Student apply(CreateStudentDTO dto) {
		Student student = new Student();
		student.setName(dto.getFullName());
		student.setGender(dto.getGender());
		student.setIdentityNumber(dto.getIdentityNumber());
		try {
			student.setDob(dateFormat.parse(dto.getDob()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void apply(Student student, UpdateStudentDTO dto) {
		if (dto.getFullName() != null)
			student.setName(dto.getFullName());
		if (dto.getGender() != null)
			student.setGender(dto.getGender());
		try {
			if (dto.getDob() != null)
				student.setDob(dateFormat.parse(dto.getDob()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
