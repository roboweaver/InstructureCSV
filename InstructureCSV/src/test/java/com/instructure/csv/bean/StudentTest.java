package com.instructure.csv.bean;

import com.instructure.csv.reader.StudentReader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import org.csveed.report.CsvException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robweaver
 */
public class StudentTest {

    private final String studentHeader = "user_id, user_name, course_id, state";
    private final String studentBody = "1, Test student, 1, active";
    private final String studentContent = (studentHeader + "\n" + studentBody);

    private final String studentHeaderOutOfOrder = "user_name, user_id, state, course_id";
    private final String studentBodyOutOfOrder = "Foo, 1, active, 2";
    private final String studentContentOutOfOrder = studentHeaderOutOfOrder + "\n" + studentBodyOutOfOrder;

    private final String studentHeaderExtraColumns = studentHeader + ", fee, fie, foe, fum";
    private final String studentContentExtraHeaders = studentHeaderExtraColumns + "\n" + studentBody;
    private final String studentContentExtraColumns = studentHeaderExtraColumns + "\n" + studentBody + ", 1, 2, 3, 4";

    public StudentTest() {
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
     * Test of getStudentId method, of class Student.
     */
    @Test
    public void testGetStudentId() {
        System.out.println("getStudentId");
        Student instance = new Student();
        Integer expResult = null;
        Integer result = instance.getStudentId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setStudentId method, of class Student.
     */
    @Test
    public void testSetStudentId() {
        System.out.println("setStudentId");
        Integer studentId = null;
        Student instance = new Student();
        instance.setStudentId(studentId);

    }

    /**
     * Test of getStudentName method, of class Student.
     */
    @Test
    public void testGetStudentName() {
        System.out.println("getStudentName");
        Student instance = new Student();
        String expResult = null;
        String result = instance.getStudentName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setStudentName method, of class Student.
     */
    @Test
    public void testSetStudentName() {
        System.out.println("setStudentName");
        String studentName = "";
        Student instance = new Student();
        instance.setStudentName(studentName);

    }

    /**
     * Test of getStudentActive method, of class Student.
     */
    @Test
    public void testGetStudentActive() {
        System.out.println("getStudentActive");
        Student instance = new Student();
        String expResult = null;
        String result = instance.getStudentActive();
        assertEquals(expResult, result);

    }

    /**
     * Test of setStudentActive method, of class Student.
     */
    @Test
    public void testSetStudentActive() {
        System.out.println("setStudentActive");
        String studentActive = "";
        Student instance = new Student();
        instance.setStudentActive(studentActive);

    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = new Student();
        String expResult = "Class: com.instructure.csv.bean.Student: user_id: null, user_name: 'null', course_id: 'null', active: 'null'";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Integration test for CSVeed read of student content
     */
    @Test
    public void testNormalFile() {
        System.out.println("Integration test for CSVeed read of student content");
        Reader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(studentContent.getBytes())));
        StudentReader studentReader = new StudentReader(reader);
        List<Student> student = studentReader.getStudents();
    }

    /**
     * Integration test for CSVeed read of student content when headers are 
     * too many, and doesn't match data (more headers than columns)
     */
    @Test(expected = CsvException.class)
    public void testOutOfOrderHeader() {

        Reader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(studentContentOutOfOrder.getBytes())));
        StudentReader studentReader = new StudentReader(reader);
        List<Student> student = studentReader.getStudents();
    }
    
    /**
     * Integration test for CSVeed read of student content when headers are 
     * out of order and has extra column data
     */

    @Test
    public void testExtraColumnsHeader() {
        Reader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(studentContentExtraColumns.getBytes())));
        StudentReader studentReader = new StudentReader(reader);
        List<Student> student = studentReader.getStudents();
    }

    /**
     * Test of getStudentCourseId method, of class Student.
     */
    @Test
    public void testGetStudentCourseId() {
        System.out.println("getStudentCourseId");
        Student instance = new Student();
        Integer expResult = null;
        Integer result = instance.getStudentCourseId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setStudentCourseId method, of class Student.
     */
    @Test
    public void testSetStudentCourseId() {
        System.out.println("setStudentCourseId");
        Integer studentCourseId = null;
        Student instance = new Student();
        instance.setStudentCourseId(studentCourseId);
        
    }

}
