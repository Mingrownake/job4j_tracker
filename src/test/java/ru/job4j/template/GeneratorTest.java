package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
public class GeneratorTest {

    @Test
    void whenTemplateAndMapMatch() {
        GeneratorClass generatorClass = new GeneratorClass();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "human");
        map.put("subject", "you");
        String result = "I am a human, Who are you?";
        assertThat(generatorClass.produce(template, map)).isEqualTo(result);
    }

    /*В шаблоне есть ключи, которых нет в карте (Map) и кидать исключение.*/
    @Test
    void whenMapHasNoTemplateKeysThenThrowException() {
        GeneratorClass generatorClass = new GeneratorClass();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("surname", "human");
        map.put("subject", "you");
        assertThatThrownBy(() -> generatorClass.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*в карте есть лишние ключи и кидать исключение.*/
    @Test
    void whenMapHasExtraKeysThenThrowException() {
        GeneratorClass generatorClass = new GeneratorClass();
        String template = "I am a ${name}";
        Map<String, String> map = new HashMap<>();
        map.put("name", "human");
        map.put("subject", "you");
        assertThatThrownBy(() -> generatorClass.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }
}