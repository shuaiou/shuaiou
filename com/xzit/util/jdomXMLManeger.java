package com.xzit.util;
import org.jdom2.input.SAXBuilder;

import com.xzit.Student.Student;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

public class jdomXMLManeger {
    private static SAXBuilder saxBuilder;
    private static Document document;

    /*
     * ??xml??????????????list????
     * @return list??????????????????
     */
    public static List<Student> toStudentFromXML(String xmlFileName){
        List<Student> list = new ArrayList<Student>();
        newInstanceSAXBuilder();
        String classPath = Tools.getPathName();
        File xmlFile = new File(classPath+"com\\xzit\\xml\\"+xmlFileName);
        try {
            document = saxBuilder.build(xmlFile);
        } catch (JDOMException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List<Element> studentList= root.getChildren();
        for(Element ele:studentList) {
//			??????????????
            Student stuObj = new Student();
            String code = ele.getAttribute("code").getValue();
            stuObj.setCode(code);
//			???????????????
            String name = ele.getChild("name").getText();
            stuObj.setName(name);
            String birthday = ele.getChild("birthday").getText();
            try {
                Date  _birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                stuObj.setBirthday(_birthday);
                list.add(stuObj);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            stuObj.setName(name);
            String sex = ele.getChild("sex").getText();
            stuObj.setSex(sex);
        }

        return list;
    }

    /*
     * ????????????????SAXBuilder????
     * */
    private static void newInstanceSAXBuilder() {
        if(saxBuilder==null) {
            saxBuilder = new SAXBuilder();
        }
    }

}
