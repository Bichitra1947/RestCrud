package com.java.service;

import java.util.List;

import com.java.binding.Student;

public interface StudentService {
	public Student insertData(Student student);
	public List<Student> retrieveDataAll();
	public Student retrieveData(Integer id);
	public Student updateData(Student student);
	public void deleteData(Integer id);

}
