package at.ac.fhbfi.springdatademo.service.mapper;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.dto.StudentDto;
import at.ac.fhbfi.springdatademo.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class StudentMapper extends AbstractMapper<StudentEntity, StudentDto> {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public StudentDto mapToDto(StudentEntity entity) {
        StudentDto studentDto = StudentDto.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .id(entity.getId())
                .build();
        studentDto.getCourses().addAll(courseMapper.mapToDto(entity.getCourses()));
        return studentDto;
    }

    @Override
    public StudentEntity mapToEntity(StudentDto studentDto) {
        return StudentEntity.builder()
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .build();
    }





}
