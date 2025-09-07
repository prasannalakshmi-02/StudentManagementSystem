package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl service;
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student) {
		service.addStudent(student);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
		
	}
	
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		return service.updateStudent(id, student);
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
		return "Student deleted with id : " + id;
	}
}
