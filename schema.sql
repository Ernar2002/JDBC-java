CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name varchar,
    surname varchar,
    ed_group varchar
)

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title varchar,
    author varchar,
    isbn varchar,
    year int,
    quantity int
)

CREATE TABLE student_book (
    student_id INT,
    book_id INT,
    PRIMARY KEY (student_id, book_id),
    CONSTRAINT fk_students FOREIGN KEY(student_id) REFERENCES students(id),
    CONSTRAINT fk_books FOREIGN KEY(book_id) REFERENCES books(id)
)
