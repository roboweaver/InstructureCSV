/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instructure.csv.reader;

import com.instructure.csv.bean.Course;
import java.io.Reader;
import java.util.List;
import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;

/**
 * Reader for the course file type ...
 * 
 * TODO: generalize the readers to use generics or factory in order to 
 *       allow for other types to be easily implemented as new beans
 * 
 * @author robweaver
 */
public class CourseReader {
    private CsvClient<Course> csvReader;
    private Reader reader;
    private List<Course> courses;

    /**
     * Constructor using a reader for the CSV input ...
     * 
     * @param reader
     */
    public CourseReader(Reader reader) {
        this.csvReader = new CsvClientImpl<>(reader, Course.class);
        this.courses = csvReader.readBeans();
        
    }

    /**
     * Get the CSV reader
     * 
     * @return the csvReader
     */
    public CsvClient<Course> getCsvReader() {
        return csvReader;
    }

    /**
     * Set the CSV reader
     * 
     * @param csvReader the csvReader to set
     */
    public void setCsvReader(CsvClient<Course> csvReader) {
        this.csvReader = csvReader;
    }

    /**
     * @return the reader (input stream)
     */
    public Reader getReader() {
        return reader;
    }

    /**
     * Set the reader (input stream)
     * 
     * @param reader the reader to set
     */
    public void setReader(Reader reader) {
        this.reader = reader;
    }

    /**
     * Get the list of courses 
     * 
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Set the list of courses 
     * 
     * @param courses the courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
