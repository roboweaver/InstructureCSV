/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instructure.csv.bean;

import java.io.Serializable;
import org.csveed.annotations.CsvCell;
import org.csveed.annotations.CsvFile;

/**
 *
 * @author robweaver
 */
@CsvFile(comment = '%', quote = '\'', escape = '\\', separator = ',')
public class Student implements Serializable {

    @CsvCell(columnIndex = 1, required = true)
    private Integer userId;
    @CsvCell(columnIndex = 2)
    private String userName;
    @CsvCell(columnIndex = 3)
    private Integer courseId;
    @CsvCell(columnIndex = 4)
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
