package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.binding.Student;
import com.java.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository repository;
	
	@Autowired
	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Student insertData(Student student) 
	{
		Student insertStudent = repository.save(student);
		return insertStudent;
	}
	
	@Override
	public Student retrieveData(Integer id) {
		Optional<Student> optional = repository.findById(id);
		Student student = optional.get();
		return student;
	}

	@Override
	public List<Student> retrieveDataAll() {
		List<Student> findAll = repository.findAll();
		return findAll;
	}

	@Override
	public Student updateData(Student student) {
		Student student1 = repository.save(student);
		return student1;
		
		
	}

	@Override
	public void deleteData(Integer id) {
		repository.deleteById(id);
	}

	
	
	


}
