CREATE TABLE IF NOT EXISTS company (
id SERIAL PRIMARY KEY,
name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS company_locales (
company_id INT REFERENCES company(id),
lang VARCHAR(2),
description VARCHAR(255) NOT NULL,
PRIMARY KEY (company_id, lang)
);

CREATE TABLE IF NOT EXISTS users (
id BIGSERIAL PRIMARY KEY,
username VARCHAR(64) NOT NULL UNIQUE,
birth_date DATE,
firstname VARCHAR(64),
lastname VARCHAR(64),
role VARCHAR(32),
company_id INTEGER REFERENCES company(id)
);

CREATE TABLE IF NOT EXISTS chat (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS users_chat (
id BIGSERIAL PRIMARY KEY,
user_id BIGINT REFERENCES users(id),
chat_id BIGINT REFERENCES chat(id)
);

CREATE TABLE IF NOT EXISTS payment (
id BIGSERIAL primary key,
amount INT,
receiver_id BIGINT references users(id)
);

INSERT INTO company (name) VALUES ('Google'),
 ('Meta'),
 ('Amazon');

INSERT INTO company_locales (company_id, lang, description) VALUES ((SELECT id FROM company WHERE name = 'Google'), 'en', 'Google description'),
((SELECT id FROM company WHERE name = 'Google'), 'ru', 'Google описание'),
((SELECT id FROM company WHERE name = 'Meta'), 'en', 'Meta description'),
((SELECT id FROM company WHERE name = 'Meta'), 'ru', 'Meta описание'),
((SELECT id FROM company WHERE name = 'Amazon'), 'en', 'Amazon description'),
((SELECT id FROM company WHERE name = 'Amazon'), 'ru', 'Amazon описание');

INSERT INTO users (birth_date, firstname, lastname, role, username, company_id) VALUES 
('1990-01-10', 'Ivan', 'Ivanov', 'ADMIN', 'ivan@gmail.com', (SELECT id FROM company WHERE name = 'Google')),
('1995-10-19', 'Petr', 'Petrov', 'USER', 'petr@gmail.com', (SELECT id FROM company WHERE name = 'Google')),
('2001-12-23', 'Sveta', 'Svetikova', 'USER', 'sveta@gmail.com', (SELECT id FROM company WHERE name = 'Google')),
('1984-03-14', 'Vlad', 'Vladikov', 'USER', 'vlad@gmail.com', (SELECT id FROM company WHERE name = 'Google')),
('1984-03-14', 'Kate', 'Smith', 'ADMIN', 'kate@gmail.com', (SELECT id FROM company WHERE name = 'Google'));

INSERT INTO payment (amount, receiver_id) VALUES (100, (SELECT id FROM users WHERE username = 'ivan@gmail.com')),
(300, (SELECT id FROM users WHERE username = 'ivan@gmail.com')),
(500, (SELECT id FROM users WHERE username = 'ivan@gmail.com')),
(250, (SELECT id FROM users WHERE username = 'petr@gmail.com'));


