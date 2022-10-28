package at.ac.fhbfi.springdatademo.service.mapper;

import at.ac.fhbfi.springdatademo.dto.CourseDto;
import at.ac.fhbfi.springdatademo.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper extends AbstractMapper<CourseEntity, CourseDto> {

    @Override
    public CourseDto mapToDto(CourseEntity courseEntity) {
        return CourseDto.builder()
                .title(courseEntity.getTitle())
                .id(courseEntity.getId())
                .build();
    }

    @Override
    public CourseEntity mapToEntity(CourseDto courseDto) {
        return CourseEntity.builder()
                .id(courseDto.getId())
                .title(courseDto.getTitle())
                .build();
    }

}
