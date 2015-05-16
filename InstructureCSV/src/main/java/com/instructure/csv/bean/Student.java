package com.instructure.csv.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName")})
public class Student implements Serializable {

    @CsvCell(columnIndex = 1, required = true)
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @CsvCell(columnIndex = 2)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;
    
    
    @CsvCell(columnIndex = 3)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @ManyToOne(optional = false)    
    private Integer courseId;
    
    @CsvCell(columnIndex = 4)
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_active", nullable = false)
    private String active;

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

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
