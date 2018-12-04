package com.studentmgr.model;

//@Entity
//@Table(name="Student")
public class Student {

	public static final String GENDER_MALE = "male";
	public static final String GENDER_FEMALE = "female";

	private String name;

	private int sid;

	private String gender;

	private String address;

	private String contactNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
