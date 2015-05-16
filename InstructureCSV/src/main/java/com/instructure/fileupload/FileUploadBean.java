package com.instructure.fileupload;

import com.instructure.csv.bean.Course;
import com.instructure.csv.bean.Student;
import com.instructure.csv.reader.CourseReader;
import com.instructure.csv.reader.StudentReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.List;
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

    private UploadedFile file;
    private Reader reader;
    private StudentReader studentReader;
    private CourseReader courseReader;

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
     */
    public void fileUploadListener(FileUploadEvent e) throws IOException {
        // Get uploaded file from the FileUploadEvent
        this.file = e.getFile();
        // Print out the information of the file
        System.out.println("Uploaded File Name Is: '" + file.getFileName() + "'. Uploaded File Size: " + file.getSize());
        if (isFileStudent()) {
            processStudents();
        } else {
            if (isFileCourse()) {
                processCourses();
            } else {
                throw new IOException("File is not student or course format");
            }
        }
    }

    /**
     * Verify that the course is a courses file based on the header starting
     * with course_id
     *
     * @return
     */
    private boolean isFileCourse() {
        return isFile("course_id");
    }

    /**
     * Figure out if file is the student upload ...
     *
     * @return
     */
    public boolean isFileStudent() {
        return isFile("user_id");
    }

    /**
     * Check if the file starts with a particular string or not
     *
     * @param startsWithString
     * @return
     */
    public boolean isFile(String startsWithString) {
        boolean returnValue = false;
        if (file != null) {
            byte[] b = file.getContents();
            if (b != null) {
                String line = new String(b);
                // See if the first row starts with "user_id"
                if (line.startsWith(startsWithString)) {
                    returnValue = true;
                }
            }
        }
        return returnValue;
    }

    /**
     * Process the students
     *
     * @return
     */
    public List<Student> processStudents() {
        reader = new StringReader(new String(file.getContents()));
        studentReader = new StudentReader(reader);
        List<Student> students = studentReader.getStudents();
        return students;
    }

    /**
     * Process the courses
     *
     * @return
     */
    public List<Course> processCourses() {
        reader = new StringReader(new String(file.getContents()));
        courseReader = new CourseReader(reader);
        List<Course> courses = courseReader.getCourses();
        return courses;
    }

}
