package ru.job4j.lombok;

import org.mapstruct.factory.Mappers;

public class LombokUsage {
    public static void main(String[] args) {
        StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
        StudentEntity studentEntity = new StudentEntity(1, "Admin");
        StudentAddress studentAddress = new StudentAddress("Kirov", "Lenina");
        StudentDTO studentDTO = studentMapper.getModelFromEntity(studentEntity, studentAddress);
        System.out.println(studentDTO);
    }
}
