package br.com.questlab.questions.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreCalculatorTest {

    private final ScoreCalculator calculator = new ScoreCalculator();

    @Test
    void shouldCalculatePercentageCorrectly() {
        assertEquals(70.0, calculator.calculatePercentage(7, 10), 0.001);
    }

    @Test
    void shouldReturnZeroWhenThereAreNoCorrectAnswers() {
        assertEquals(0.0, calculator.calculatePercentage(0, 10), 0.001);
    }

    @Test
    void shouldRejectZeroQuestions() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculatePercentage(0, 0));
    }

    @Test
    void shouldRejectMoreCorrectAnswersThanTotal() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculatePercentage(11, 10));
    }
}
