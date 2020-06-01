package ru.otus.hw01.domain;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private long id;
    private String question;
    private String solution;
    private List<Answer> answers = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (question != null ? !question.equals(item.question) : item.question != null) return false;
        if (solution != null ? !solution.equals(item.solution) : item.solution != null) return false;
        return answers != null ? answers.equals(item.answers) : item.answers == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        return result;
    }
}
