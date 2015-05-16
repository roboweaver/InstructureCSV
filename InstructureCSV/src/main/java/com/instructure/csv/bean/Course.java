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
@CsvFile(comment = '%', quote = '\'', escape = '\\', separator = ',', useHeader = true)
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByStudentActive", query = "SELECT c FROM Course c WHERE c.studentActive = :studentActive"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName")})
public class Course implements Serializable {

    @CsvCell(columnIndex = 1, required = true)
    @Id
    @GeneratedValue
    @Column(name = "course_id", nullable = false)
    private Integer courseId;
    
    @CsvCell(columnIndex = 2)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "course_name", nullable = false, length = 255)
    private String courseName;
    
    @CsvCell(columnIndex = 3)
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_active", nullable = false)
    private String active;

    /**
     * @return the courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the active
     */
    public String getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(String active) {
        this.active = active;
    }

}
