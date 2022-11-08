package com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Student;
import com.data.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentrepository;
	
	@Override
	public List<Student> getStudents() {
	    return studentrepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentrepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentrepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentrepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		
		studentrepository.deleteById(id);
		
	}

}
