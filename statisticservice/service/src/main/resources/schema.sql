DROP TABLE IF EXISTS statistic;

--сохраняем развернуто все данные по использованию сервисов
CREATE TABLE IF NOT EXISTS statistic (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    service_name varchar(50),
    uri varchar(50),
    ip varchar(20),
    request_date TIMESTAMP WITHOUT TIME ZONE);