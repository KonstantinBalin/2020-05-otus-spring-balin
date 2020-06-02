package ru.otus.hw01.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"question", "solution", "answers"})
public class Item {
    private final long id;
    private String question;
    private String solution;
    private List<Answer> answers = new ArrayList<>();
}
