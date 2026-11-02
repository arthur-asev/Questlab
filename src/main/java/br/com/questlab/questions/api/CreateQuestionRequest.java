package br.com.questlab.questions.api;

import br.com.questlab.questions.domain.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateQuestionRequest(
        @NotBlank(message = "O enunciado é obrigatório.")
        @Size(max = 10000, message = "O enunciado deve ter no máximo 10000 caracteres.")
        String statement,

        @NotNull(message = "A dificuldade é obrigatória.")
        Difficulty difficulty,

        @Size(max = 120, message = "A origem deve ter no máximo 120 caracteres.")
        String source
) {
}
