package com.example.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository repo;
	

	public StudentServiceImpl(StudentRepository repo) {
		this.repo = repo;
	}

	@Override
	public Student addStudent(Student student) {
		return repo.save(student);
		
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(int id, Student student) {
		Optional<Student> existingStudent = repo.findById(id);
        if (existingStudent.isPresent()) {
            Student s = existingStudent.get();
            s.setName(student.getName());
            s.setAge(student.getAge());
            s.setBranch(student.getBranch());
            s.setMarks(student.getMarks());
            return repo.save(s);
        }
        return null;
	}
	

	@Override
	public void deleteStudent(int id) {
		repo.deleteById(id);;
		
	}
	
	
	
	
	
	
	
	
	

}
