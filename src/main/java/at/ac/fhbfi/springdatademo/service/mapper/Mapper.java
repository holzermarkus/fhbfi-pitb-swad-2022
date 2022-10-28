package at.ac.fhbfi.springdatademo.service.mapper;

public interface Mapper<ENTITY, DTO> {

    DTO mapToDto(ENTITY entity);
    ENTITY mapToEntity(DTO dto);

}
