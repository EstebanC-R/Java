-- ================================================================================
-- Script de creación de tablas para el Sistema de Gestión de Películas
-- ================================================================================
-- Base de datos: PostgreSQL (recomendado) o MySQL
-- ================================================================================

-- ================================================================================
-- TABLA: users
-- ================================================================================
-- Almacena información de usuarios que escriben reseñas de películas
-- ================================================================================

CREATE TABLE users (
    id_user BIGSERIAL PRIMARY KEY,

    -- username único, máximo 50 caracteres
    username VARCHAR(50) NOT NULL UNIQUE,

    -- email único, máximo 254 caracteres (límite RFC 5321)
    email VARCHAR(254) NOT NULL UNIQUE,

    -- Marca de tiempo de creación (no actualizable)
    registered_at TIMESTAMP WITH TIME ZONE NOT NULL,

    -- Marca de tiempo de última actualización
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,

    -- Restricción: verificar que el email tenga un formato válido
    CONSTRAINT email_format CHECK (email LIKE '%@%.%')
);

-- Índices para optimizar búsquedas frecuentes
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);


-- ================================================================================
-- TABLA: movies
-- ================================================================================
-- Almacena información de películas
-- ================================================================================

CREATE TABLE movies (
    id_movie BIGSERIAL PRIMARY KEY,

    -- Título de la película, máximo 300 caracteres
    title VARCHAR(300) NOT NULL,

    -- Duración en minutos (debe ser positivo)
    duration INTEGER NOT NULL CHECK (duration > 0),

    -- Fecha de estreno
    release_date DATE NOT NULL,

    -- Presupuesto en USD (15 dígitos totales, 2 decimales)
    -- Ejemplo: 123456789012.34
    budget NUMERIC(15, 2),

    -- Género de la película (valores predefinidos)
    genre VARCHAR(20) NOT NULL CHECK (genre IN (
        'ACTION', 'DRAMA', 'COMEDY', 'HORROR', 'SCI_FI', 'THRILLER'
    )),

    -- Restricción: el título no puede estar en blanco
    CONSTRAINT title_not_blank CHECK (char_length(btrim(title)) > 0)
);

-- Índices para optimizar búsquedas
CREATE INDEX idx_movies_title ON movies(title);
CREATE INDEX idx_movies_genre ON movies(genre);
CREATE INDEX idx_movies_release_date ON movies(release_date);


-- ================================================================================
-- TABLA: reviews
-- ================================================================================
-- Almacena reseñas de películas escritas por usuarios
-- Tabla de unión con datos adicionales (relación muchos-a-muchos materializada)
-- ================================================================================

CREATE TABLE reviews (
    id_review BIGSERIAL PRIMARY KEY,

    -- Título de la reseña, máximo 150 caracteres
    title VARCHAR(150) NOT NULL,

    -- Contenido de la reseña (texto largo, mínimo 20 caracteres)
    content TEXT NOT NULL CHECK (char_length(btrim(content)) >= 20),

    -- Calificación numérica (1 a 10)
    rating INTEGER NOT NULL CHECK (rating >= 1 AND rating <= 10),

    -- Marca de tiempo de creación (no actualizable)
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,

    -- Marca de tiempo de última actualización
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,

    -- Clave foránea: Usuario que escribió la reseña
    -- ON DELETE CASCADE: si se elimina el usuario, se eliminan sus reseñas
    id_user_fk BIGINT NOT NULL,
    CONSTRAINT fk_reviews_user FOREIGN KEY (id_user_fk)
        REFERENCES users(id_user) ON DELETE CASCADE,

    -- Clave foránea: Película sobre la que es la reseña
    -- ON DELETE CASCADE: si se elimina la película, se eliminan sus reseñas
    id_movie_fk BIGINT NOT NULL,
    CONSTRAINT fk_reviews_movie FOREIGN KEY (id_movie_fk)
        REFERENCES movies(id_movie) ON DELETE CASCADE,

    -- Restricción: un usuario no puede escribir dos reseñas de la misma película
    UNIQUE(id_user_fk, id_movie_fk),

    -- Restricción: el título de la reseña no puede estar en blanco
    CONSTRAINT review_title_not_blank CHECK (char_length(btrim(title)) > 0)
);

-- Índices para optimizar búsquedas
CREATE INDEX idx_reviews_user ON reviews(id_user_fk);
CREATE INDEX idx_reviews_movie ON reviews(id_movie_fk);
CREATE INDEX idx_reviews_rating ON reviews(rating);
CREATE INDEX idx_reviews_created_at ON reviews(created_at);


-- ================================================================================
-- DATOS DE PRUEBA (OPCIONAL)
-- ================================================================================
-- Descomenta estas líneas si quieres poblar la base de datos con datos iniciales
-- ================================================================================

-- -- Insertar usuarios de ejemplo
-- INSERT INTO users (username, email, registered_at, updated_at) VALUES
--     ('juan_perez', 'juan@example.com', NOW(), NOW()),
--     ('maria_garcia', 'maria@example.com', NOW(), NOW()),
--     ('carlos_lopez', 'carlos@example.com', NOW(), NOW());

-- -- Insertar películas de ejemplo
-- INSERT INTO movies (title, duration, release_date, budget, genre) VALUES
--     ('The Matrix', 136, '1999-03-31', 63000000.00, 'SCI_FI'),
--     ('Inception', 148, '2010-07-16', 160000000.00, 'SCI_FI'),
--     ('The Dark Knight', 152, '2008-07-18', 185000000.00, 'ACTION'),
--     ('Pulp Fiction', 154, '1994-10-14', 8000000.00, 'DRAMA'),
--     ('Forrest Gump', 142, '1994-07-06', 55000000.00, 'DRAMA');

-- -- Insertar reseñas de ejemplo
-- INSERT INTO reviews (title, content, rating, created_at, updated_at, id_user_fk, id_movie_fk) VALUES
--     ('Obra maestra del cine', 'Una película absolutamente asombrosa que revolucionó la industria del cine. Los efectos especiales, la trama y los actores son excepcionales.', 10, NOW(), NOW(), 1, 1),
--     ('Excelente película de ciencia ficción', 'Inception es una película que te hace pensar. Los efectos visuales son impresionantes y la trama es muy creativa y compleja.', 9, NOW(), NOW(), 2, 2),
--     ('Superhéroes de acción pura', 'The Dark Knight es una secuela que supera al original. Heath Ledger da una actuación magistral como Joker.', 9, NOW(), NOW(), 3, 3);


-- ================================================================================
-- VISTAS ÚTILES (OPCIONAL)
-- ================================================================================

-- Vista para ver el promedio de ratings por película
-- CREATE VIEW vw_movies_avg_rating AS
-- SELECT
--     m.id_movie,
--     m.title,
--     m.genre,
--     COUNT(r.id_review) as total_reviews,
--     ROUND(AVG(r.rating), 2) as average_rating
-- FROM movies m
-- LEFT JOIN reviews r ON m.id_movie = r.id_movie_fk
-- GROUP BY m.id_movie, m.title, m.genre
-- ORDER BY average_rating DESC;

-- Vista para ver el número de reseñas por usuario
-- CREATE VIEW vw_users_review_count AS
-- SELECT
--     u.id_user,
--     u.username,
--     COUNT(r.id_review) as total_reviews,
--     ROUND(AVG(r.rating), 2) as avg_rating_given
-- FROM users u
-- LEFT JOIN reviews r ON u.id_user = r.id_user_fk
-- GROUP BY u.id_user, u.username
-- ORDER BY total_reviews DESC;

-- ================================================================================
-- FIN DEL SCRIPT
-- ================================================================================