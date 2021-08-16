package com.xzit.Student;

import java.util.Date;

public class Student {
	
	private String code;						
	private String name;
	private Date birthday;
	private String sex; 

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student(String code, String name, Date birthday, String sex) {
		this.code = code;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
		
	}

}
