package com.studentmgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgr.model.Student;
import com.studentmgr.service.HRService;
import com.studentmgr.service.StudentService;

@Service
public class HRServiceImpl implements HRService {

	@Autowired
	StudentService studentService;

	private static int idCounter = 0;
	List<Student> studentWaitingList = new ArrayList<>();

	@Override
	public String accept(int sid, boolean decision) throws Exception {
		String returnConfirmation = "Student with ID: " + sid + " does not rejestered before!!";
		if (sid <= idCounter) {
			for (Student student : studentWaitingList) {
				if (student.getSid() == sid) {
					if (decision) {
						returnConfirmation = studentService.add(student);
					} else {
						studentWaitingList.remove(student);
						returnConfirmation = "Student with ID:" + student.getSid() + " is rejected sucessfully";
					}
					break;
				}
			}
		}
		return returnConfirmation;
	}

	@Override
	public Student register(Student object) throws Exception {

		idCounter++;
		object.setSid(idCounter);
		studentWaitingList.add(object);

		return object;
	}

}
