package com.instructure.fileupload;

import com.instructure.csv.bean.Course;
import com.instructure.csv.bean.Student;
import com.instructure.csv.jsf.util.JsfUtil;
import com.instructure.csv.reader.CourseReader;
import com.instructure.csv.reader.StudentReader;
import com.instructure.csv.session.CourseFacade;
import com.instructure.csv.session.StudentFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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

    @EJB
    private StudentFacade studentFacade;
    @EJB
    private CourseFacade courseFacade;

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
     * @throws java.io.IOException
     */
    public void fileUploadListener(FileUploadEvent e) throws IOException {
        // Get uploaded file from the FileUploadEvent
        this.file = e.getFile();
        // Print out the information of the file
        System.out.println("Uploaded File Name Is: '" + file.getFileName() + "'. Uploaded File Size: " + file.getSize());
        if (isFileStudent()) {
            List<Student> students = parseStudents();
            students = persistStudents(students);
            JsfUtil.addSuccessMessage("Processed " + students.size() + " students");
        } else {
            if (isFileCourse()) {
                List<Course> courses = parseCourses();
                courses = persistCourses(courses);
                JsfUtil.addSuccessMessage("Processed " + courses.size() + " courses");

            } else {
                try {
                    JsfUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Format Error", "File '" + file.getFileName() + "' is not student or course format");
                } catch (NullPointerException npe) {
                    // This only happens when running tests
                    // TODO: Need to figure out how to mock the above properly
                    //       so that we don't need this unnecessary try/catch
                }
                //throw new IOException("File is not student or course format");
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
     * @param fieldNameString
     * @return
     */
    public boolean isFile(String fieldNameString) {
        boolean returnValue = false;
        if (file != null) {
            InputStream inputStream;
            try {
                inputStream = file.getInputstream();

                BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
                String header = fileReader.readLine();
                if (header != null) {
                    // See if the first row starts with the string we're looking for
                    if (header.contains(fieldNameString)) {
                        returnValue = true;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnValue;
    }

    public List<Student> persistStudents(List<Student> inputStudents) {
        for (Student student : inputStudents) {
            System.out.println(student.toString());
            getStudentFacade().edit(student);
        }
        return inputStudents;
    }

    public List<Course> persistCourses(List<Course> inputCourses) {
        for (Course course : inputCourses) {
            System.out.println(course.toString());
            getCourseFacade().edit(course);
        }
        return inputCourses;
    }

    /**
     * Parse the students
     *
     * @return
     */
    public List<Student> parseStudents() throws IOException {
        System.out.println("Processing students");
        reader = new BufferedReader(new InputStreamReader(file.getInputstream()));
        studentReader = new StudentReader(reader);
        List<Student> students = studentReader.getStudents();
        System.out.println("Found " + students.size() + " students");
        return students;
    }

    /**
     * Parse the courses
     *
     * @return
     */
    public List<Course> parseCourses() throws IOException {
        System.out.println("Processing courses");
        reader = new BufferedReader(new InputStreamReader(file.getInputstream()));
        courseReader = new CourseReader(reader);
        List<Course> courses = courseReader.getCourses();
        System.out.println("Found " + courses.size() + " courses");
        return courses;
    }

    /**
     * @return the studentFacade
     */
    public StudentFacade getStudentFacade() {
        return studentFacade;
    }

    /**
     * @return the studentFacade
     */
    public CourseFacade getCourseFacade() {
        return courseFacade;
    }
}
