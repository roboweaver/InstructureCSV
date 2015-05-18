package com.instructure.csv.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.csveed.annotations.CsvCell;
import org.csveed.annotations.CsvFile;

/**
 *
 * @author robweaver
 */
@CsvFile(comment = '%', quote = '\'', escape = '\\', separator = ',')
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByStudentActive", query = "SELECT s FROM Student s WHERE s.studentActive = :studentActive"),
    @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "Student.findByCourseId", query = "Select s FROM Student s WHERE s.studentCourseId = :studentCourseId")})
public class Student implements Serializable {

    @CsvCell(columnName = "student_id", required = true)
    @Id
    @GeneratedValue
    @Column(name = "student_id", nullable = false)
    private Integer studentId;
    
    @CsvCell(columnName = "student_name")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_name", nullable = false, length = 255)
    private String studentName;
    
    
    @CsvCell(columnName = "course_id")
    @Basic(optional = false)
    @Column(name = "student_course_id", nullable = false)  
    // TODO: add join relationship here and replace the member with Course object
    private Integer studentCourseId;
    
    @CsvCell(columnName = "state")
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_active", nullable = false)
    private String studentActive;

    /**
     * @return the studentId
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentCourseId
     */
    public Integer getStudentCourseId() {
        return studentCourseId;
    }

    /**
     * @param studentCourseId
     */
    public void setStudentCourseId(Integer studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    /**
     * @return the studentActive
     */
    public String getStudentActive() {
        return studentActive;
    }

    /**
     * @param active the studentActive to set
     */
    public void setStudentActive(String active) {
        this.studentActive = active;
    }

    /**
     * Representation of the object ...
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Class: ");
        sb.append(this.getClass().getName());
        sb.append(": user_id: ");
        sb.append(this.studentId);
        sb.append(", user_name: '");
        sb.append(this.studentName);
        sb.append("', course_id: (");
        sb.append(this.studentCourseId);
        sb.append("), active: '");
        sb.append(this.getStudentActive());
        sb.append("'");
        return sb.toString();
    }
}
