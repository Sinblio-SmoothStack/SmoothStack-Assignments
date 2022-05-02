package QuestionAnswer.ModelsTest;

import QuestionAnswer.Models.Question;
import QuestionAnswer.Models.QuestionType;
import QuestionAnswer.Repositories.QuestionRepository;
import QuestionAnswer.Repositories.QuestionTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootTest
public class QuestionTypeTest {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Test
    void crudTest() {
        QuestionType questionType = new QuestionType();
        questionType.setTypeName("Free Form");
        questionTypeRepository.save(questionType);
    }
}
