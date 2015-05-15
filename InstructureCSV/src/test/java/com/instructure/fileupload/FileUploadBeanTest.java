/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instructure.fileupload;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author robweaver
 */
public class FileUploadBeanTest {

    private static final String MOCK_FILE_NAME = "myFileName.csv";
    private static final Long MOCK_FILE_SIZE = 5000l;
    private static UploadedFile mockFile = Mockito.mock(UploadedFile.class);
    private FileUploadBean instance;
    String studentHeader = "course_id, course_name, state";
    private byte[] studentHeaderBytes = (studentHeader).getBytes();
    String courseHeader = "user_id, user_name, course_id, state";
    private byte[] courseHeaderBytes = (courseHeader).getBytes();
    
    public FileUploadBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        mockFile = Mockito.mock(UploadedFile.class);
        when(mockFile.getFileName()).thenReturn(MOCK_FILE_NAME);
        when(mockFile.getSize()).thenReturn(MOCK_FILE_SIZE);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new FileUploadBean();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFile method, of class FileUploadBean.
     */
    @Test
    public void testGetFile() {
        System.out.println("getFile");
        FileUploadBean instance = new FileUploadBean();
        UploadedFile expResult = null;
        UploadedFile result = instance.getFile();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFile method, of class FileUploadBean.
     */
    @Test
    public void testSetFile() {
        System.out.println("setFile");
        UploadedFile file = null;
        FileUploadBean instance = new FileUploadBean();
        instance.setFile(file);

    }

    /**
     * Test of fileUploadListener method, of class FileUploadBean.
     */
    @Test
    public void testFileUploadListener() {
        System.out.println("fileUploadListener");

        FileUploadEvent e = Mockito.mock(FileUploadEvent.class);
        when(e.getFile()).thenReturn(mockFile);
        instance.fileUploadListener(e);

    }

    /**
     * Test of isFileStudent method with student content, of class FileUploadBean.
     * 
     * Should return true
     */
    @Test
    public void testIsFileStudent() {
        System.out.println("isFileStudent");
        when(mockFile.getContents()).thenReturn(studentHeaderBytes);
        boolean expResult = true;
        boolean result = instance.isFileStudent(); 
        assertEquals(expResult, result);

    }

    /**
     * Test of isFileStudent method for course content, of class FileUploadBean.
     * 
     * Should return false
     */
    @Test
    public void testIsFileStudentCourse() {
        System.out.println("isFileStudent");
        when(mockFile.getContents()).thenReturn(courseHeaderBytes);
        boolean expResult = false;
        boolean result = instance.isFileStudent(); 
        assertEquals(expResult, result);

    }


    /**
     * Test of isFileStudent method for course content, of class FileUploadBean.
     * 
     * Should return false
     */
    @Test
    public void testIsFileStudentNoContent() {
        System.out.println("isFileStudent");
        byte[] emptyByteArray = null;
        when(mockFile.getContents()).thenReturn(emptyByteArray);
        boolean expResult = false;
        boolean result = instance.isFileStudent(); 
        assertEquals(expResult, result);

    }

    /**
     * Test of processStudents method, of class FileUploadBean.
     */
    @Test
    public void testProcessStudents() {
        System.out.println("processStudents");
        
        instance.processStudents();

    }

    /**
     * Test of processCourses method, of class FileUploadBean.
     */
    @Test
    public void testProcessCourses() {
        System.out.println("processCourses");
        FileUploadBean instance = new FileUploadBean();
        instance.processCourses();

    }

}
