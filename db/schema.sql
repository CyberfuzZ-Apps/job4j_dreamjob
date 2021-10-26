CREATE TABLE IF NOT EXISTS post
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    created     TIMESTAMP
);


CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS cities
(
    id   SERIAL PRIMARY KEY,
    city TEXT NOT NULL
);


CREATE TABLE IF NOT EXISTS candidates
(
    id      SERIAL PRIMARY KEY,
    name    TEXT NOT NULL,
    created TIMESTAMP,
    city_id INTEGER
        CONSTRAINT candidates_cities_id_fk
            REFERENCES cities
);

CREATE UNIQUE INDEX IF NOT EXISTS cities_id_uindex
    ON cities (id);


INSERT INTO cities (city) VALUES ('Москва');
INSERT INTO cities (city) VALUES ('Краснодар');
INSERT INTO cities (city) VALUES ('Пермь');
INSERT INTO cities (city) VALUES ('Абакан');
INSERT INTO cities (city) VALUES ('Санкт-Петербург');
INSERT INTO cities (city) VALUES ('Новосибирск');
INSERT INTO cities (city) VALUES ('Екатеринбург');
INSERT INTO cities (city) VALUES ('Казань');
INSERT INTO cities (city) VALUES ('Нижний Новгород');
INSERT INTO cities (city) VALUES ('Челябинск');
INSERT INTO cities (city) VALUES ('Самара');
INSERT INTO cities (city) VALUES ('Омск');
INSERT INTO cities (city) VALUES ('Ростов-на-Дону');
INSERT INTO cities (city) VALUES ('Уфа');