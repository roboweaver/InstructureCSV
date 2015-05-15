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
    private final String MOCK_FILE_NAME = "myFileName.csv";
    private final Long MOCK_FILE_SIZE = 5000l;
    
    public FileUploadBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
        UploadedFile mockFile = Mockito.mock(UploadedFile.class);
        when(mockFile.getFileName()).thenReturn(MOCK_FILE_NAME);
        when(mockFile.getSize()).thenReturn(MOCK_FILE_SIZE);
        FileUploadEvent e = Mockito.mock(FileUploadEvent.class);
        when(e.getFile()).thenReturn(mockFile);
        FileUploadBean instance = new FileUploadBean();
        instance.fileUploadListener(e);
        
    }

    /**
     * Test of isFileStudent method, of class FileUploadBean.
     */
    @Test
    public void testIsFileStudent() {
        System.out.println("isFileStudent");
        FileUploadBean instance = new FileUploadBean();
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
        FileUploadBean instance = new FileUploadBean();
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
