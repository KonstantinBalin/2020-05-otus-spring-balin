package ru.otus.spring.hw05.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.hw05.domain.Comment;
import ru.otus.spring.hw05.service.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentCommands {

    private final CommentService commentService;

    @ShellMethod(value = "Add comment", key = {"addComment"})
    public void addComment(@ShellOption String comment, @ShellOption Long bookId) {
        commentService.add(new Comment(null, bookId, comment));
    }

    @ShellMethod(value = "Update Comment", key={"updateComment"})
    public void updateComment(@ShellOption long id, @ShellOption String comment) {
        commentService.update(id, comment);
    }

    @ShellMethod(value = "Delete comment", key = {"deleteComment"})
    public void deleteComment(@ShellOption long id) { commentService.getById(id);}

    @ShellMethod(value = "Get comment", key = {"getComment"})
    public void getComment(@ShellOption long id) {
        System.out.println(commentService.getById(id));
    }

    @ShellMethod(value = "Get comment list", key = {"getComments"})
    public void getCommentList() {
        System.out.println(commentService.getAll());
    }

}
