package br.com.questlab.questions.api;

import br.com.questlab.questions.domain.Difficulty;

import java.time.OffsetDateTime;

public record QuestionResponse(
        Long id,
        String statement,
        Difficulty difficulty,
        String source,
        OffsetDateTime createdAt
) {
}
