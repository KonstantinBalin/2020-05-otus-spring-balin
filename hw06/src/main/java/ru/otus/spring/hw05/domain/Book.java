package ru.otus.spring.hw05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(name = "author-entity-graph", attributeNodes = {@NamedAttributeNode("author")})
//@NamedEntityGraph(name = "comment-entity-graph", attributeNodes = {@NamedAttributeNode("comments")})
//@NamedEntityGraph(name = "genre-entity-graph", attributeNodes = {@NamedAttributeNode("genre")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="books")
@NamedEntityGraph(name = "book-author-genre-entity-graph", attributeNodes = {@NamedAttributeNode("author"), @NamedAttributeNode("genre")})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
    private Author author;

    @OneToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
    private Genre genre;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private List<Comment> comments;
}
