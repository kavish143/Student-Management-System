package com.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.data.entities.Student;
import com.data.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/students")
	public String getStudents(Model model) {
		model.addAttribute("students", studentservice.getStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentservice.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		//get student from database by id
		Student existingstudent = studentservice.getStudentById(id);
		existingstudent.setId(id);
		existingstudent.setFirstname(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());
		//save update student object
		studentservice.updateStudent(existingstudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentservice.deleteStudentById(id);
		return "redirect:/students";
	}
}
















