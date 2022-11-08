package com.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.data.entities.Student;
import com.data.repository.StudentRepository;

@SpringBootApplication
public class StudentDataApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentDataApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
      
//		Student student1 = new Student(null, "Abhishek", "Bobde", "abhishek@gmail.com");
//		studentRepository.save(student1);
		
	}

}
