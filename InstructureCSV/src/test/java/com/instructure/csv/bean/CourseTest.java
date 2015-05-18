/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instructure.csv.bean;

import com.instructure.csv.reader.CourseReader;
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
public class CourseTest {

    private final String courseHeader = "course_id, course_name, state";
    private final String courseBody = "1, Test course, active";
    private final String courseContent = (courseHeader + "\n" + courseBody);

    private final String courseHeaderOutOfOrder = "course_name, course_id, state";
    private final String courseContentOutOfOrder = courseHeaderOutOfOrder + "\n" + courseBody;

    private final String courseHeaderExtraColumns = courseHeader + ", fee, fie, foe, fum";
    private final String courseContentExtraHeaders = courseHeaderExtraColumns + "\n" + courseBody;
    private final String courseContentExtraColumns = courseHeaderExtraColumns + "\n" + courseBody + ", 1, 2, 3, 4";

    public CourseTest() {
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
     * Test of getCourseId method, of class Course.
     */
    @Test
    public void testGetCourseId() {
        System.out.println("getCourseId");
        Course instance = new Course();
        Integer expResult = null;
        Integer result = instance.getCourseId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCourseId method, of class Course.
     */
    @Test
    public void testSetCourseId() {
        System.out.println("setCourseId");
        Integer courseId = null;
        Course instance = new Course();
        instance.setCourseId(courseId);

    }

    /**
     * Test of getCourseName method, of class Course.
     */
    @Test
    public void testGetCourseName() {
        System.out.println("getCourseName");
        Course instance = new Course();
        String expResult = null;
        String result = instance.getCourseName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCourseName method, of class Course.
     */
    @Test
    public void testSetCourseName() {
        System.out.println("setCourseName");
        String courseName = "";
        Course instance = new Course();
        instance.setCourseName(courseName);

    }

    /**
     * Test of getCourseActive method, of class Course.
     */
    @Test
    public void testGetCourseActive() {
        System.out.println("getCourseActive");
        Course instance = new Course();
        String expResult = null;
        String result = instance.getCourseActive();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCourseActive method, of class Course.
     */
    @Test
    public void testSetCourseActive() {
        System.out.println("setCourseActive");
        String courseActive = "";
        Course instance = new Course();
        instance.setCourseActive(courseActive);

    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Course instance = new Course();
        String expResult = "Class: com.instructure.csv.bean.Course: course_id: null, user_name: 'null', active: 'null'";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Integration test for CSVeed read of course content
     */
    @Test
    public void testNormalFile() {
        System.out.println("Integration test for CSVeed read of course content");
        Reader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(courseContent.getBytes())));
        CourseReader courseReader = new CourseReader(reader);
        List<Course> course = courseReader.getCourses();
    }

    /**
     * Integration test for CSVeed read of course content when headers are 
     * too many, and doesn't match data (more headers than columns)
     */
    @Test(expected = CsvException.class)
    public void testOutOfOrderHeader() {

        Reader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(courseContentExtraHeaders.getBytes())));
        CourseReader courseReader = new CourseReader(reader);
        List<Course> course = courseReader.getCourses();
    }
    
    /**
     * Integration test for CSVeed read of course content when headers are 
     * out of order and has extra column data
     */

    @Test
    public void testExtraColumnsHeader() {
        Reader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(courseContentExtraColumns.getBytes())));
        CourseReader courseReader = new CourseReader(reader);
        List<Course> course = courseReader.getCourses();
    }

}
