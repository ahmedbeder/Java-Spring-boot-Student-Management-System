package com.studentmgr.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgr.dao.StudentDao;
import com.studentmgr.model.Student;
import com.studentmgr.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	protected StudentDao studentDao;
	
	@Override
	public Student getById(int id) throws Exception{
		try{
			return studentDao.getById(id);
		}catch(Exception de){
			LOGGER.error(de.getMessage());
			de.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Student> getAll() throws Exception{
		try{
			return studentDao.getAll();
		}catch(Exception de){
			LOGGER.error(de.getMessage());
			de.printStackTrace();
		}
		return null;
	}
	@Override
	public String add(Student obj) throws Exception{
		try{
			boolean isAdded =  studentDao.add(obj);
			if (isAdded) {
				return "Student ID= " + obj.getSid() + " is added sucessfully";
			} else {
				return "Student ID= " + obj.getSid() + " is already exist!!";
			}
		}catch(Exception de){
			LOGGER.error(de.getMessage());
			de.printStackTrace();
		}
		return "";
	}
	
	@Override
	public Student edit(Student obj) throws Exception{
		try{
			studentDao.modify(obj);
			return obj;
		}catch(Exception de){
			LOGGER.error(de.getMessage());
			de.printStackTrace();
		}
		return obj;
	}

	@Override
	public String delete(Student object) throws Exception{
		try{
			boolean isdeleted =  studentDao.delete(object);
			if (isdeleted) {
				return "Student ID= " + object.getSid() + "is deleted sucessfully";
			} else {
				return "Student ID= " + object.getSid() + "is does not exist!!";
			}
		}catch(Exception de){
			LOGGER.error(de.getMessage());
			de.printStackTrace();
		}
		return "";
	}

	
}
