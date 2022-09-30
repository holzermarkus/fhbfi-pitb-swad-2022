package at.ac.fhbfi.springdatademo.repository;

import at.ac.fhbfi.springdatademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContainsIgnoreCase(String name);

}
