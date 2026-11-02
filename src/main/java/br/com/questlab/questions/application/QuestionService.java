package br.com.questlab.questions.application;

import br.com.questlab.questions.api.CreateQuestionRequest;
import br.com.questlab.questions.api.QuestionResponse;
import br.com.questlab.questions.domain.Question;
import br.com.questlab.questions.persistence.QuestionRepository;
import br.com.questlab.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public QuestionResponse create(CreateQuestionRequest request) {
        String statement = request.statement().trim();
        String source = request.source() == null || request.source().isBlank()
                ? null
                : request.source().trim();

        Question question = new Question(statement, request.difficulty(), source);
        return toResponse(questionRepository.save(question));
    }

    @Transactional(readOnly = true)
    public List<QuestionResponse> findAll() {
        return questionRepository.findAll().stream()
                .map(QuestionService::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public QuestionResponse findById(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Questão " + id + " não encontrada."));
        return toResponse(question);
    }

    private static QuestionResponse toResponse(Question question) {
        return new QuestionResponse(
                question.getId(),
                question.getStatement(),
                question.getDifficulty(),
                question.getSource(),
                question.getCreatedAt()
        );
    }
}
