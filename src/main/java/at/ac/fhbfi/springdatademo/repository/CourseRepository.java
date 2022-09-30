package at.ac.fhbfi.springdatademo.repository;

import at.ac.fhbfi.springdatademo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
