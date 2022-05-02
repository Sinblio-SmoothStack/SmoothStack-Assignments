package QuestionAnswer.Repositories;

import QuestionAnswer.Models.FreeFormQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeFormQuestionRepository extends JpaRepository<FreeFormQuestion, Integer> {
}