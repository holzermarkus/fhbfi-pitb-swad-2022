package at.ac.fhbfi.springdatademo.service;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.dto.StudentDto;
import at.ac.fhbfi.springdatademo.entity.CourseEntity;
import at.ac.fhbfi.springdatademo.entity.StudentEntity;
import at.ac.fhbfi.springdatademo.repository.CourseRepository;
import at.ac.fhbfi.springdatademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveNewStudent(StudentDto student) {
        StudentEntity studentEntity = StudentEntity.builder()
                .name(student.getName())
                .email(student.getEmail())
                .build();
        studentRepository.save(studentEntity);
    }

    @Override
    public void addCourseToStudent(StudentDto student, CourseDto course) {
        StudentEntity studentEntity = studentRepository.findById(student.getId()).orElse(null);
        CourseEntity courseEntity = courseRepository.findById(course.getId()).orElse(null);
        studentEntity.getCourses().add(courseEntity);
    }

    @Override
    public List<StudentDto> getStudentList() {
        List<StudentDto> students = new ArrayList<>();
        studentRepository.findAll().forEach(studentEntity -> {
            StudentDto studentDto = StudentDto.builder()
                    .name(studentEntity.getName())
                    .email(studentEntity.getEmail())
                    .id(studentEntity.getId())
                    .build();
            studentEntity.getCourses().forEach(courseEntity -> {
                studentDto.getCourses().add(CourseDto.builder()
                        .id(courseEntity.getId())
                        .title(courseEntity.getTitle())
                        .build());
            });
            students.add(studentDto);
        });
        return students;
    }
}
