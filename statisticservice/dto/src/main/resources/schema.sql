DROP TABLE IF EXISTS statistic;
DROP TABLE IF EXISTS summary_statistic;

--сохраняем развернуто все данные по использованию сервисов
CREATE TABLE IF NOT EXISTS statistic (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    service_name varchar(50),
    uri varchar(50),
    ip varchar(20),
    request_date TIMESTAMP WITHOUT TIME ZONE);

-- Сохраняем итоговую статистику за день с учетом уникальных и не уникальных IP
CREATE TABLE IF NOT EXISTS summary_statistic (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    service_name varchar(50),
    uri varchar(50),
    uniq boolean,
    request_date TIMESTAMP WITHOUT TIME ZONE,
    hits BIGINT
    );