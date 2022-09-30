package at.ac.fhbfi.springdatademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "UNI_GROUP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
