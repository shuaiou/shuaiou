package com.xzit.doc;
import com.xzit.util.jdomXMLManeger;
import com.xzit.Student.Student;

import java.text.SimpleDateFormat;

public class ReadXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("学生信息：");
		System.out.println("学号\t姓名\t生日\t性别");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		for(Student stu:jdomXMLManeger.toStudentFromXML("students.xml")){
			System.out.println("-----------------------------------------------------------------------");
			System.out.println(stu.getCode()+"\t"+stu.getName()+"\t"+sf.format(stu.getBirthday())+"\t"+stu.getSex());
		}
	}

}
