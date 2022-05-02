package QuestionAnswer.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "free_form_question")
public class FreeFormQuestion implements Serializable {
    @Id
    private Integer id;

    @OneToOne (cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    private Question question;

    @Column(name = "question_text", length = 500)
    private String questionText;

    @Column(name = "official_answer", length = 500)
    private String officialAnswer;

    public String getOfficialAnswer() {
        return officialAnswer;
    }

    public void setOfficialAnswer(String officialAnswer) {
        this.officialAnswer = officialAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}