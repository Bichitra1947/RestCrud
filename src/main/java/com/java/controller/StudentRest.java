package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.binding.Student;
import com.java.service.StudentServiceImpl;

@RestController
public class StudentRest {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	
	@PostMapping("/insert1")
	public Student insertData(@RequestBody Student student) {
		Student student2 = studentServiceImpl.insertData(student);
		
		return student2 ;
	}
	
	@PostMapping("/insert2")
	public Student insertData1(@RequestParam String name,
								@RequestParam String email,
								@RequestParam Long phoneNo) {
		
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhoneNo(phoneNo);
		Student studentData = studentServiceImpl.insertData(student);
		if(studentData!=null) {
			System.out.println("data inserted");
		}else {
			System.out.println("data insertion fail");
		}
		return student;
	}
	
	@GetMapping("/getAll")
	public List<Student> retrieveDataAll() {
		
		List<Student> retrieveData = studentServiceImpl.retrieveDataAll();
		
		return retrieveData;
	}
	@GetMapping("/get/{id}")
	public Student retrieveData(@PathVariable Integer id) {
		Student student = studentServiceImpl.retrieveData(id);
		return student;
	}
	
	
	
	@PutMapping("/update1")
	public Student updateData1(@RequestBody Student student) {
		Student std = studentServiceImpl.updateData(student);
		return std;
	}
	
	@PutMapping("/update2")
	public Student updateData2(@RequestParam Integer id,
								@RequestParam String name,
								@RequestParam String email,
								@RequestParam Long phoneNo) {
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPhoneNo(phoneNo);
		
		studentServiceImpl.updateData(student);
		return student;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable Integer id) {
		studentServiceImpl.deleteData(id);
		
		return "delete success";
	}

}




















