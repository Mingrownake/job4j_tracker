package ru.job4j.lombok;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {
    @NotNull
    @Getter
    @EqualsAndHashCode.Include
    private final int id;
    @Getter
    @Setter
    private String name;
}
