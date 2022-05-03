package QuestionAnswer.ModelsTest;

import QuestionAnswer.Models.*;
import QuestionAnswer.Repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class QuestionTest {

    @Autowired
    QuestionTypeRepository questionTypeRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    FreeFormQuestionRepository freeFormQuestionRepository;
    @Autowired
    MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    @Autowired
    MultipleChoiceOptionRepository multipleChoiceOptionRepository;

    @Test
    void crudTest() {
        QuestionType questionType = new QuestionType();
        questionType.setTypeName("Free Form");
        questionTypeRepository.save(questionType);

        Question question = new Question();
        question.setType(questionType);
        questionRepository.save(question);

        FreeFormQuestion freeFormQuestion = new FreeFormQuestion();
        freeFormQuestion.setQuestionText("Did I make a question?");
        freeFormQuestion.setOfficialAnswer("Yes?");
        freeFormQuestion.setQuestion(question);
        freeFormQuestionRepository.save(freeFormQuestion);

        questionType = new QuestionType();
        questionType.setTypeName("Multiple Choice");
        questionTypeRepository.save(questionType);

        question = new Question();
        question.setType(questionType);
        questionRepository.save(question);

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        multipleChoiceQuestion.setQuestion(question);
        multipleChoiceQuestionRepository.save(multipleChoiceQuestion);

        List<MultipleChoiceOption> options = Arrays.asList(new MultipleChoiceOption(), new MultipleChoiceOption(), new MultipleChoiceOption(), new MultipleChoiceOption());
        options.get(0).setCorrect(1);
        for (MultipleChoiceOption option:options) {
            option.setOptionText("Option Text");
            option.setQuestion(question);
        }
        multipleChoiceOptionRepository.saveAll(options);
    }
}
