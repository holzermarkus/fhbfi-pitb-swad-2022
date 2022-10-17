package at.ac.fhbfi.springdatademo;

import at.ac.fhbfi.springdatademo.entity.CourseEntity;
import at.ac.fhbfi.springdatademo.entity.StudentEntity;
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
class JpaRepositoryTests {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateNewStudent() {
        studentRepository.save(StudentEntity.builder().name("Anna Musterfrau").build());
        studentRepository.save(StudentEntity.builder().name("Max Mustermann").build());
        log.info(studentRepository.count() + " rows.");
        List<StudentEntity> students = studentRepository.findAll();
        students.forEach(o -> log.info(o.toString()));
        System.out.println("--------");
        studentRepository.findByNameContainsIgnoreCase("max").forEach(o -> log.info(o.toString()));
    }

    @Test
    void testStudentCourseMapping() {
        StudentEntity anna = studentRepository.save(StudentEntity.builder().name("Anna Musterfrau").build());
        StudentEntity max = studentRepository.save(StudentEntity.builder().name("Max Mustermann").build());
        CourseEntity sw = courseRepository.save(CourseEntity.builder().title("SW Architektur").build());
        anna.getCourses().add(sw);
        studentRepository.save(anna);
        studentRepository.findAll().forEach(o -> log.info(o.toString()));

    }

}
