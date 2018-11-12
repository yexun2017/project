package com.wwx.myo2o.test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/11/1  9:35
 **/
public class TestClassload {
    public static void main(String[] args) {
        System.out.println(TestClassload.class.getClassLoader().getClass().getName());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        ClassLoader c=TestClassload.class.getClassLoader();
        System.out.println(c);
        ClassLoader c1=c.getParent();
        System.out.println(c1);
        ClassLoader c2=c1.getParent();
        System.out.println(c2);
        ObjectMapper objectMapper=new ObjectMapper();
        JsonFactory jsonFactory=objectMapper.getFactory();
        DocumentBuilderFactory  documentBuilderFactory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder d = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
