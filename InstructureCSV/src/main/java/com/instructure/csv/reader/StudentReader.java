package com.instructure.csv.reader;

import com.instructure.csv.bean.Student;
import java.io.Reader;
import java.util.List;
import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;

/**
 * Reader for the student file type ...
 * 
 * @author robweaver
 */
public class StudentReader {
    private CsvClient<Student> csvReader;
    private Reader reader;
    private List<Student> students;

    public StudentReader(Reader reader) {
        this.csvReader = new CsvClientImpl<>(reader, Student.class);
        this.students = csvReader.readBeans();
        
    }

    /**
     * @return the csvReader
     */
    public CsvClient<Student> getCsvReader() {
        return csvReader;
    }

    /**
     * @param csvReader the csvReader to set
     */
    public void setCsvReader(CsvClient<Student> csvReader) {
        this.csvReader = csvReader;
    }

    /**
     * @return the reader
     */
    public Reader getReader() {
        return reader;
    }

    /**
     * @param reader the reader to set
     */
    public void setReader(Reader reader) {
        this.reader = reader;
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
