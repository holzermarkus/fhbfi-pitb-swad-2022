package at.ac.fhbfi.springdatademo;

import at.ac.fhbfi.springdatademo.entity.Course;
import at.ac.fhbfi.springdatademo.entity.Student;
import at.ac.fhbfi.springdatademo.repository.CourseRepository;
import at.ac.fhbfi.springdatademo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
class SpringDataDemoApplicationTests {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateNewStudent() {
        studentRepository.save(Student.builder().name("Anna Musterfrau").build());
        studentRepository.save(Student.builder().name("Max Mustermann").build());
        log.info(studentRepository.count() + " rows.");
        List<Student> students = studentRepository.findAll();
        students.forEach(o -> log.info(o.toString()));
        System.out.println("--------");
        studentRepository.findByNameContainsIgnoreCase("max").forEach(o -> log.info(o.toString()));
    }

    @Test
    void testStudentCourseMapping() {
        Student anna = studentRepository.save(Student.builder().name("Anna Musterfrau").build());
        Student max = studentRepository.save(Student.builder().name("Max Mustermann").build());
        Course sw = courseRepository.save(Course.builder().title("SW Architektur").build());
        anna.getCourses().add(sw);
        studentRepository.save(anna);
        studentRepository.findAll().forEach(o -> log.info(o.toString()));

    }

}
