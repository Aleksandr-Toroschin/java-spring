BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO products (title, cost) VALUES
('Ручка', 10),
('Стол', 420),
('Карандаш', 2),
('Мыло', 59);

COMMIT;