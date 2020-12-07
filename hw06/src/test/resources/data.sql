insert into AUTHORS (id, name) values (1, 'Test Konstantin');
insert into AUTHORS (id, name) values (2, 'Test2 Konstantin');
insert into GENRES (id, description) values (1, 'Test Fantasy');
insert into GENRES (id, description) values (2, 'Test Fantasy second');
insert into BOOKS (id, title, author_id, genre_id) values (1, 'Test Lord of the Rings', 1, 1);
insert into BOOKS (id, title, author_id, genre_id) values (2, 'Test Lord of the Rings episode 2', 2, 2);
insert into COMMENTS (id, book_id, text) values (1, 1, 'Test comment');
insert into COMMENTS (id, book_id, text) values (2, 1, 'Test comment');
insert into COMMENTS (id, book_id, text) values (3, 2, 'Test comment');
insert into COMMENTS (id, book_id, text) values (4, 2, 'Test comment');
insert into COMMENTS (id, book_id, text) values (5, 2, 'Test comment');

