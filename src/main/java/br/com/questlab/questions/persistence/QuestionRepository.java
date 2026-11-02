package br.com.questlab.questions.persistence;

import br.com.questlab.questions.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
