insert into AUTHORS (id, name) values (1, 'Konstantin');
insert into GENRES (id, description) values (1, 'Fantasy');
insert into BOOKS (id, title, author_id, genre_id) values (1, 'Lord of the Rings', 1, 1);
insert into COMMENTS (id, book_id, comment) values (1, 1, 'Test comment');
insert into COMMENTS (id, book_id, comment) values (2, 1, 'Test comment2');


-- Fantasy.
-- Adventure.
-- Romance.
-- Contemporary.
-- Dystopian.
-- Mystery.
-- Horror.
-- Thriller.