package com.studentmgr.service;

import java.util.List;

import com.studentmgr.model.Student;

public interface StudentService {
	Student getById(int id) throws Exception;

	String add(Student obj) throws Exception;

	Student edit(Student obj) throws Exception;

	String delete(Student object) throws Exception;

	List<Student> getAll() throws Exception;
    
	
}
