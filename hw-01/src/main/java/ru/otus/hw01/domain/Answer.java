package ru.otus.hw01.domain;


public class Answer {
    private String answer;
    private boolean correct;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer1 = (Answer) o;

        if (correct != answer1.correct) return false;
        return answer != null ? answer.equals(answer1.answer) : answer1.answer == null;
    }

    @Override
    public int hashCode() {
        int result = answer != null ? answer.hashCode() : 0;
        result = 31 * result + (correct ? 1 : 0);
        return result;
    }
}
