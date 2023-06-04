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

CREATE TABLE IF NOT EXISTS payment (
id BIGSERIAL primary key,
amount INT,
receiver_id BIGINT references users(id)
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