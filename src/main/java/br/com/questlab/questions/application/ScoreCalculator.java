package br.com.questlab.questions.application;

public class ScoreCalculator {

    public double calculatePercentage(int correct, int total) {
        if (total <= 0) {
            throw new IllegalArgumentException("O total de questões deve ser maior que zero.");
        }
        if (correct < 0 || correct > total) {
            throw new IllegalArgumentException("Quantidade de acertos inválida.");
        }
        return correct * 100.0 / total;
    }
}
