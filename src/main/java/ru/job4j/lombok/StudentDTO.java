package ru.job4j.lombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    private int id;
    private String name;
    private String city;
    private String street;
}
