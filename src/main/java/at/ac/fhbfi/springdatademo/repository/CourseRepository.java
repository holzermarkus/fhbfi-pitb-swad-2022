package at.ac.fhbfi.springdatademo.repository;

import at.ac.fhbfi.springdatademo.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
