/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instructure.fileupload;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author robweaver
 */
@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable {
        UploadedFile file;
 
    /**
     *
     * @return
     */
    public UploadedFile getFile() {
        return file;
    }
 
    /**
     *
     * @param file
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
 
    /**
     * Listen for the uploaded file and return it
     * 
     * @param e 
     * @return  
     */
    public void fileUploadListener(FileUploadEvent e){
        // Get uploaded file from the FileUploadEvent
        this.file = e.getFile();
        // Print out the information of the file
        System.out.println("Uploaded File Name Is: '"+file.getFileName()+"'. Uploaded File Size: "+file.getSize());
        if (isFileStudent()){
            processStudents();
        } else {
            processCourses();
        }
    }

    public boolean isFileStudent() {
        return true;
    }

    public void processStudents() {
    }

    public void processCourses() {
    }
    
}
