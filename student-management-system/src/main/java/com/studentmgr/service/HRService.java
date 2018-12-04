package com.studentmgr.service;

import com.studentmgr.model.Student;

public interface HRService {
	String accept(int sid, boolean decision) throws Exception;

	Student register(Student object) throws Exception;
    
	
}
