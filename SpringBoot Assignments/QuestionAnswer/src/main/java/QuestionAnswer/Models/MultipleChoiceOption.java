package QuestionAnswer.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "multiple_choice_option")
public class MultipleChoiceOption implements Serializable {
    @Id
    private Integer id;

    @OneToOne (optional = false)
    @MapsId
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    private Question question;

    @Column(name = "option_text", length = 500)
    private String optionText;

    @Column(name = "correct", nullable = false)
    private Integer correct;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
}