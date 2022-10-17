package at.ac.fhbfi.springdatademo.service;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void saveNewStudent(StudentDto student);
    void addCourseToStudent(StudentDto student, CourseDto course);
    List<StudentDto> getStudentList();

}
