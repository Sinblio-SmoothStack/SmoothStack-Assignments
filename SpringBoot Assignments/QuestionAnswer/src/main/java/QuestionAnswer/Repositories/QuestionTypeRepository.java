package QuestionAnswer.Repositories;

import QuestionAnswer.Models.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
    Optional<QuestionType> findById(Integer id);
}