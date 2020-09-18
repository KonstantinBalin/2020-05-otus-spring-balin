DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS
(
    ID   BIGINT auto_increment PRIMARY KEY,
    NAME VARCHAR(255)
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES
(
    ID          BIGINT auto_increment PRIMARY KEY,
    DESCRIPTION VARCHAR(255)
);

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS
(
    ID        BIGINT auto_increment PRIMARY KEY,
    TITLE     VARCHAR(255),
    AUTHOR_ID BIGINT,
    GENRE_ID  BIGINT,
    FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS (ID),
    FOREIGN KEY (GENRE_ID) REFERENCES GENRES (ID)
);

DROP TABLE IF EXISTS COMMENTS;
CREATE TABLE COMMENTS
(
    ID      BIGINT auto_increment PRIMARY KEY,
    BOOK_ID BIGINT references BOOKS(id) on delete cascade,
    COMMENT VARCHAR(MAX)
);