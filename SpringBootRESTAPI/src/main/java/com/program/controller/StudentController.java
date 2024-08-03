package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.program.entity.Student;
import com.program.repository.studentRepository;

@RestController
public class StudentController {
	@Autowired
	studentRepository repo;

	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		List<Student> student = repo.findAll();
		return student;

	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) 
	{
		Student student = repo.findById(id).get();
		return student;
	}
	@PostMapping("/students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student)
	{
		repo.save(student);
		
	}
	
	@PutMapping("/students/update/{id}")
	public Student updateStudents(@PathVariable int id)
	{
		Student student=repo.findById(id).get();
		student.setName("yash");
		student.setPercentage(92);
		repo.save(student);
		return student;	
	}
	 @DeleteMapping("/students/delete/{id}")
	 public void removeStudent(@PathVariable int id)
	 {
		 Student student=repo.findById(id).get();
		 repo.delete(student);
	 }
}
