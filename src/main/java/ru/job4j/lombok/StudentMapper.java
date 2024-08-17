package ru.job4j.lombok;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {
    StudentDTO getModelFromEntity(StudentEntity student, StudentAddress studentAddress);
}
