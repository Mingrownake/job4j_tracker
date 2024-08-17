package ru.job4j.lombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentEntity {
    private int id;
    private String name;
}
