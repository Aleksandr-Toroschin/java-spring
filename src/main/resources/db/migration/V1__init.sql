BEGIN;

DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO categories (title) VALUES
('Канцтовары'),
('Мебель для гостиной'),
('Ковры'),
('Бытовая химия');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost int, id_category bigint, FOREIGN KEY (id_category) REFERENCES categories (id));
INSERT INTO products (title, cost, id_category) VALUES
('Ручка', 10, 1),
('Стол', 420, 2),
('Карандаш', 2, 1),
('Карандаш синий', 5, 1),
('Карандаш красный', 10, 1),
('Карандаш желтый', 8, 1),
('Ручка синяя', 19, 1),
('Мыло', 59, 4);

COMMIT;