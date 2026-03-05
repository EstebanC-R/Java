
CREATE TABLE creator (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE series (
    id_series BIGSERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    release_year INT NOT NULL,
    description VARCHAR(250) NOT NULL,
    id_creator_fk INT NOT NULL,
    CONSTRAINT fk_creator_id FOREIGN KEY (id_creator_fk) REFERENCES creator(id)
);