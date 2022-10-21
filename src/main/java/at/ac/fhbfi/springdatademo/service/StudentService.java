package at.ac.fhbfi.springdatademo.service;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void saveNewStudent(StudentDto student);
    List<StudentDto> getStudentList();
    void addCourseToStudent(StudentDto student, CourseDto course);

}
