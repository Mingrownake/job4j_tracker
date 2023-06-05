package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults1() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenLinearFunctionThenLinearResults2() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(0, 2, x -> 1 * x - 1);
        List<Double> expected = Arrays.asList(-1D, 0D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults1() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> 5 * x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(8D, 25D, 52D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults2() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(-3, 5, x -> 0 * x * x - 2 * x + 7);
        List<Double> expected = Arrays.asList(13D, 11D, 9D, 7D, 5D, 3D, 1D, -1D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults1() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 5, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(1D, 4D, 27D, 256D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults2() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(-1, 2, Math::abs);
        List<Double> expected = Arrays.asList(1D, 0D, 1D);
        assertThat(result).containsAll(expected);
    }

}