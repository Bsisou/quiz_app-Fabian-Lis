package com.bsisou.quiz;

public class TrueFalse {
    private int questionID;
    private Boolean answer;

    public TrueFalse(int questionResourseID, boolean trueOrfalse){
        questionID = questionResourseID;
        answer = trueOrfalse;
    }

    public int getQuestionID() {
        return questionID;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

}
