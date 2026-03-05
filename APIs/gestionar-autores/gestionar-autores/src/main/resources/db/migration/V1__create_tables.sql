-- ==========================
-- Tabla: authors
-- ==========================

CREATE TABLE authors (
    id_author BIGSERIAL PRIMARY KEY,
    name_author VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    age INTEGER NOT NULL
);

-- ==========================
-- Tabla: books
-- ==========================

CREATE TABLE books (
    id_book BIGSERIAL PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    page_number INTEGER NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    release_year DATE NOT NULL,
    id_author_fk BIGINT NOT NULL,
    CONSTRAINT fk_books_author
        FOREIGN KEY (id_author_fk)
        REFERENCES authors(id_author)
        ON DELETE CASCADE
);