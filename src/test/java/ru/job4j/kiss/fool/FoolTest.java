package ru.job4j.kiss.fool;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class FoolTest {

    @ParameterizedTest(name = "{index} - {0} Input is correct")
    @CsvSource(
            {
                    "2, 2",
                    "15, FizzBuzz",
                    "3, Fizz",
                    "5, Buzz"
            }
    )
    void whenInputIsCorrect(int startAt, String answer) {
        Fool fool = new Fool();
        assertThat(fool.getAnswer(startAt)).isEqualTo(answer);
    }
}


