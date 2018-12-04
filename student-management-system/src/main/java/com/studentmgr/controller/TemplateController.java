package com.studentmgr.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentmgr.json.JsonResponse;
import com.studentmgr.model.Student;
import com.studentmgr.service.HRService;
import com.studentmgr.service.StudentService;

@RestController
public class TemplateController {

	private static final String STUFF = "stuff";
	private static final String HR = "HR";
	
	private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class);
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private HRService hrService;

	@RequestMapping("/list")
	public JsonResponse listPage(@RequestParam(name = "userType", required = true) String userType){
		
		List<Student> students = new ArrayList<>();
		try{
			if(userType.equals(STUFF))
				students = studentService.getAll();
			else 
				return new JsonResponse("Not Authorized!");
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
			
		return new JsonResponse(students);
	}
	
	@RequestMapping("/register")
	public JsonResponse registerStudent(@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "gender", required = true) String gender,
			@RequestParam(name = "address", required = true) String address,
			@RequestParam(name = "contactNo", required = true) String contactNo) throws Exception{
		
		Student student = new Student();
		student.setName(name);
		student.setGender(gender);
		student.setAddress(address);
		student.setContactNo(contactNo);
		
		hrService.register(student);
		
		return new JsonResponse(student);
	}
	
	@RequestMapping("/approve")
	public JsonResponse approveRegistration(@RequestParam(name = "userType", required = true) String userType,
			@RequestParam(name = "sid", required = true) String sid, 
			@RequestParam(name = "decision", required = true) boolean decision){
		
		try{
			if(userType.equals(HR)) {
				String response = hrService.accept(Integer.parseInt(sid), decision);
				return new JsonResponse(response);
			}
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return new JsonResponse("User type: " + userType + " Not Authorized to approve student registration!");
	}
	
	
}
