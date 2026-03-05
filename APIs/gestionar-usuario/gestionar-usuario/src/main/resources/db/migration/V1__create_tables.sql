-- ==========================
-- Tabla: users
-- ==========================

CREATE TABLE users (
    id_user BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(250) NOT NULL,
    age INTEGER NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE
);

-- ==========================
-- Tabla: orders
-- ==========================

CREATE TABLE orders (
    id_order BIGSERIAL PRIMARY KEY,
    description TEXT,
    id_user_fk BIGINT NOT NULL,
    CONSTRAINT fk_orders_user
        FOREIGN KEY (id_user_fk)
        REFERENCES users(id_user)
        ON DELETE CASCADE
);