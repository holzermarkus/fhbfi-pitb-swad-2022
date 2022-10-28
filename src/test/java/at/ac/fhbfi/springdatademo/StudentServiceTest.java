package at.ac.fhbfi.springdatademo;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.dto.StudentDto;
import at.ac.fhbfi.springdatademo.entity.CourseEntity;
import at.ac.fhbfi.springdatademo.repository.CourseRepository;
import at.ac.fhbfi.springdatademo.repository.StudentRepository;
import at.ac.fhbfi.springdatademo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void testSaveNewStudent() {
        StudentDto annaMusterfrau = StudentDto.builder()
                .email("anna.musterfrau@uni.at")
                .name("Anna Musterfrau")
                .build();
        studentService.saveNewStudent(annaMusterfrau);
        Assertions.assertNotNull(studentRepository.findByEmail("anna.musterfrau@uni.at"));
        Assertions.assertEquals("Anna Musterfrau",
                studentRepository.findByEmail("anna.musterfrau@uni.at")
                        .getName());
    }

    @Test
    void testGetStudentByEMail() {
        StudentDto annaMusterfrau = StudentDto.builder()
                .email("anna.musterfrau@uni.at")
                .name("Anna Musterfrau")
                .build();
        studentService.saveNewStudent(annaMusterfrau);
        StudentDto studentDto = studentService.getStudentByEMail("anna.musterfrau@uni.at");
        Assertions.assertNotNull(studentDto);
        Assertions.assertEquals("Anna Musterfrau", studentDto.getName());
    }

    @Test
    void testGetStudentList() {
        List<StudentDto> students = studentService.getStudentList();
        Assertions.assertNotNull(students);
        Assertions.assertEquals(0, students.size());

        StudentDto annaMusterfrau = StudentDto.builder()
                .email("anna.musterfrau@uni.at")
                .name("Anna Musterfrau")
                .build();
        studentService.saveNewStudent(annaMusterfrau);

        students = studentService.getStudentList();
        Assertions.assertNotNull(students);
        Assertions.assertEquals(1, students.size());

    }

    @Test
    void testAddCourseToStudent() {
        StudentDto annaMusterfrau = StudentDto.builder()
                .email("anna.musterfrau@uni.at")
                .name("Anna Musterfrau")
                .build();
        studentService.saveNewStudent(annaMusterfrau);
        CourseEntity courseEntity = CourseEntity.builder()
                .title("SW Architektur")
                .build();
        courseRepository.save(courseEntity);
        CourseDto courseDto = CourseDto.builder().build();
        courseRepository.findAll().forEach(c -> {
            courseDto.setId(c.getId());
            courseDto.setTitle(c.getTitle());
        });
        StudentDto studentDto = studentService.getStudentList().get(0);

        studentService.addCourseToStudent(studentDto, courseDto);

        StudentDto savedStudent = studentService.getStudentList().get(0);
        Assertions.assertNotNull(savedStudent);
        Assertions.assertEquals(1, studentRepository.findByEmail("anna.musterfrau@uni.at").getCourses().size());
        Assertions.assertEquals(1, savedStudent.getCourses().size());
    }


}
