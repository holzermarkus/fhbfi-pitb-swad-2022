package at.ac.fhbfi.springdatademo;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.dto.StudentDto;
import at.ac.fhbfi.springdatademo.entity.CourseEntity;
import at.ac.fhbfi.springdatademo.entity.StudentEntity;
import at.ac.fhbfi.springdatademo.repository.CourseRepository;
import at.ac.fhbfi.springdatademo.repository.StudentRepository;
import at.ac.fhbfi.springdatademo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
public class StudentCourseTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void testSaveNewStudent() {
        log.info(studentRepository.count() + " records.");
        StudentDto student = StudentDto.builder()
                .name("Anna Musterfrau")
                .build();
        studentService.saveNewStudent(student);
        log.info(studentRepository.count() + " records.");
        Assertions.assertEquals(1, studentRepository.count());
        Assertions.assertEquals("Anna Musterfrau", studentRepository.findAll().get(0).getName());
    }

    @Test
    void testGetStudentList() {
        StudentDto student = StudentDto.builder()
                .name("Anna Musterfrau")
                .build();
        studentService.saveNewStudent(student);

        List<StudentDto> students = studentService.getStudentList();
        Assertions.assertNotNull(students);
        Assertions.assertEquals(studentRepository.count(), students.size());
    }

    @Test
    void testAddCourseToStudent() {
        StudentDto student = StudentDto.builder()
                .name("Anna Musterfrau")
                .build();
        studentService.saveNewStudent(student);
        courseRepository.save(CourseEntity.builder().title("SW Architecture").build());
        // studentDto
        StudentDto annaMusterfrau = studentService.getStudentList().get(0);
        // courseDto
        CourseEntity courseEntity = courseRepository.findAll().get(0);
        CourseDto swArchitecture = CourseDto.builder().title(courseEntity.getTitle()).id(courseEntity.getId()).build();

        studentService.addCourseToStudent(annaMusterfrau, swArchitecture);

        annaMusterfrau = studentService.getStudentList().get(0);
        log.info(annaMusterfrau.toString());

        StudentEntity annaMusterfrauEntity = studentRepository.findAll().get(0);
        log.info(annaMusterfrauEntity.toString());
        Assertions.assertEquals(1, annaMusterfrauEntity.getCourses().size());


        Assertions.assertEquals(1, annaMusterfrau.getCourses().size());




    }


}
