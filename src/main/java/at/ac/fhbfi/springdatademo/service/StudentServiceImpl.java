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
    public List<StudentDto> getStudentList() {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findAll().forEach(studentEntity -> {
            List<CourseDto> courseDtos = new ArrayList<>();
            studentEntity.getCourses().forEach(courseEntity -> {
                CourseDto courseDto = CourseDto.builder()
                        .title(courseEntity.getTitle())
                        .id(courseEntity.getId())
                        .build();
                courseDtos.add(courseDto);
            });

            StudentDto studentDto = StudentDto.builder()
                    .name(studentEntity.getName())
                    .email(studentEntity.getEmail())
                    .id(studentEntity.getId())
                    .build();
            studentDto.getCourses().addAll(courseDtos);
            studentDtos.add(studentDto);
        });
        return studentDtos;
    }

    @Override
    @Transactional
    public void addCourseToStudent(StudentDto student, CourseDto course) {
        StudentEntity studentEntity = studentRepository.findById(student.getId()).orElse(null);
        CourseEntity courseEntity = courseRepository.findById(course.getId()).orElse(null);

        if (studentEntity == null || courseEntity == null) {
            throw new IllegalArgumentException("student or course not found.");
        }

        studentEntity.getCourses().add(courseEntity);

    }
}
