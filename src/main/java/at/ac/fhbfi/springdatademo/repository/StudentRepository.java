package at.ac.fhbfi.springdatademo.repository;

import at.ac.fhbfi.springdatademo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByNameContainsIgnoreCase(String name);

    StudentEntity findByEmail(String email);

}
