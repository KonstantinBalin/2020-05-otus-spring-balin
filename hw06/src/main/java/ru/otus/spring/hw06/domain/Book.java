package ru.otus.spring.hw06.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;



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

}


