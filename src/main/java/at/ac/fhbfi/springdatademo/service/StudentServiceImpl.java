package at.ac.fhbfi.springdatademo.service;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.dto.StudentDto;
import at.ac.fhbfi.springdatademo.entity.CourseEntity;
import at.ac.fhbfi.springdatademo.entity.StudentEntity;
import at.ac.fhbfi.springdatademo.repository.CourseRepository;
import at.ac.fhbfi.springdatademo.repository.StudentRepository;
import at.ac.fhbfi.springdatademo.service.mapper.StudentMapper;
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
    @Autowired
    private StudentMapper studentMapper;



    @Override
    public void saveNewStudent(StudentDto student) {
        studentRepository.save(studentMapper.mapToEntity(student));
    }

    @Override
    public StudentDto getStudentByEMail(String email) {
        return studentMapper.mapToDto(studentRepository.findByEmail(email));
    }


    @Override
    public List<StudentDto> getStudentList() {
        return studentMapper.mapToDto(studentRepository.findAll());
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
