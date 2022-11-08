package com.data.service;

import java.util.List;

import com.data.entities.Student;

public interface StudentService {


	List<Student> getStudents();
	
	Student saveStudent(Student student); 
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
