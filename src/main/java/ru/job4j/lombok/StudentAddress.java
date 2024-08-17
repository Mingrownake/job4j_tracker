package ru.job4j.lombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentAddress {
    private String city;
    private String street;
}
