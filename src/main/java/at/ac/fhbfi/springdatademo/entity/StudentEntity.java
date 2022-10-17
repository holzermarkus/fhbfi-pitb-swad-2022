package at.ac.fhbfi.springdatademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UNI_STUDENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(name = "STUDENT_TO_COURSE",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = @JoinColumn(name = "fk_course"))
    private final Set<CourseEntity> courses = new HashSet<>();

}
