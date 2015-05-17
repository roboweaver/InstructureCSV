package com.instructure.fileupload;

import com.instructure.csv.bean.Course;
import com.instructure.csv.bean.Student;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
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
    private final String studentHeader = "user_id, user_name, course_id, state";
    private final String studentBody = "1, Test User, 1, active";
    private final String courseHeader = "course_id, course_name, state";
    private final String courseBody = "1, Test course, active";
    private final String studentContent = (studentHeader + "\n" + studentBody);
    private final String courseContent = (courseHeader + "\n" + courseBody);

    /**
     *
     */
    public FileUploadBeanTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        mockFile = Mockito.mock(UploadedFile.class);
        when(mockFile.getFileName()).thenReturn(MOCK_FILE_NAME);
        when(mockFile.getSize()).thenReturn(MOCK_FILE_SIZE);

    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        instance = new FileUploadBean();
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getFile method, of class FileUploadBean.
     */
    @Test
    public void testGetFile() {
        System.out.println("getFile");
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
        instance.setFile(file);

    }

    /**
     * Test of fileUploadListener method, of class FileUploadBean.
     *
     * @throws java.io.IOException
     */ 
    @Test
    public void testFileUploadListener() throws IOException {
        System.out.println("fileUploadListener");

        FileUploadEvent e = Mockito.mock(FileUploadEvent.class);
        when(e.getFile()).thenReturn(mockFile);
        instance.fileUploadListener(e);

    }

    /**
     * Test of isFileStudent method with student content, of class
     * FileUploadBean.
     *
     * Should return true
     *
     * @throws java.io.IOException
     */
    @Test
    public void testIsFileStudent() throws IOException {
        System.out.println("isFileStudent");
        when(mockFile.getInputstream()).thenReturn(new ByteArrayInputStream(studentContent.getBytes()));
        instance.setFile(mockFile);
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
    public void testIsFileStudentCourse() throws IOException {
        System.out.println("isFileStudent");
        when(mockFile.getInputstream()).thenReturn(new ByteArrayInputStream(courseContent.getBytes()));
        instance.setFile(mockFile);
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
        instance.setFile(mockFile);
        boolean expResult = false;
        boolean result = instance.isFileStudent();
        assertEquals(expResult, result);

    }

    /**
     * Test of parseStudents method, of class FileUploadBean.
     */
    @Test
    public void testProcessStudents() throws IOException {
        System.out.println("processStudents");
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("Test User");
        student.setStudentActive("active");
        student.setStudentCourseId(1);
        // Set up the mocks ...

        when(mockFile.getInputstream()).thenReturn(new ByteArrayInputStream(studentContent.getBytes()));
        instance.setFile(mockFile);

        List<Student> returnedList = instance.parseStudents();

        assertEquals(returnedList.size(), 1);
        for (Student ret : returnedList) {
            assertEquals(ret.getStudentId(), student.getStudentId());
            assertEquals(ret.getStudentName(), student.getStudentName());
            assertEquals(ret.getStudentCourseId(), student.getStudentCourseId());
            assertEquals(ret.getStudentActive(), student.getStudentActive());
        }

    }

    /**
     * Test of parseCourses method, of class FileUploadBean.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testProcessCourses() throws IOException {
        System.out.println("processCourses");
        Course course = new Course();
        course.setCourseName("Test course");
        course.setCourseActive("active");
        course.setCourseId(1);

        // Set up the mocks ...       
        when(mockFile.getInputstream()).thenReturn(new ByteArrayInputStream(courseContent.getBytes()));
        instance.setFile(mockFile);

        List<Course> returnedList = instance.parseCourses();

        assertEquals(returnedList.size(), 1);
        for (Course ret : returnedList) {
            assertEquals(ret.getCourseId(), course.getCourseId());
            assertEquals(ret.getCourseName(), course.getCourseName());
            assertEquals(ret.getCourseActive(), course.getCourseActive());
        }

    }

    /**
     * Test of isFile method, of class FileUploadBean.
     */
    @Test
    public void testIsFile() {
        System.out.println("isFile");
        String startsWithString = "";
        boolean expResult = false;
        boolean result = instance.isFile(startsWithString);
        assertEquals(expResult, result);

    }

    private void given() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
