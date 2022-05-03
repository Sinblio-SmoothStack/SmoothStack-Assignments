package QuestionAnswer.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "multiple_choice_question")
public class MultipleChoiceQuestion implements Serializable {
    @Id
    private Integer id;

    @OneToOne (optional = false)
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    @MapsId
    private Question question;

    @OneToMany
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Set<MultipleChoiceOption> options;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<MultipleChoiceOption> getOptions() {
        return options;
    }

    public void setOptions(Set<MultipleChoiceOption> options) {
        this.options = options;
    }
}