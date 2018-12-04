package com.studentmgr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.studentmgr.dao.StudentDao;
import com.studentmgr.model.Student;

/**
 * 
 * to simplfy the DB
 *
 */
@Repository
public class StudentDaoImpl implements StudentDao {

	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	private List<Student> studentList = new ArrayList<Student>();

	@Override
	public boolean add(Student object) throws Exception {
		boolean isExistflag = false; 
		if (logger.isDebugEnabled())
			logger.debug("type student add");
		try {
			for (Student student : studentList) {
				if (student.getSid() == object.getSid()) {
					isExistflag = true;
				}
			}
			if(!isExistflag) {
				studentList.add(object);
				return true;
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return false;
	}

	@Override
	public void modify(Student object) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("type student modify");
		try {
			List<Student> studentListCopy = studentList;
			for (Student student : studentListCopy) {
				if (student.getSid() == object.getSid()) {
					studentList.remove(student);
					studentList.add(object);
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public Student getById(int id) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("type Student getById");
		try {
			for (Student student : studentList) {
				if (student.getSid() == id) {
					return student;
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return null;
	}

	@Override
	public List<Student> getAll() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("type student getAll");

		try {
			return studentList;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public boolean delete(Student object) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("type student delete");
		try {
			List<Student> studentListCopy = studentList;
			for (Student student : studentListCopy) {
				if (student.getSid() == object.getSid()) {
					studentList.remove(student);
					return true;
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return false;
	}

}
