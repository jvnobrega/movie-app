CREATE TABLE actor
(
    id                 serial PRIMARY KEY,
    uuid               varchar(36) NOT NULL,
    first_name         varchar(30) NOT NULL,
    last_name          varchar(40) NULL,
    birthdate          date        NOT NULL,
    version            integer     NOT NULL,
    input_date         TIMESTAMP   NOT NULL,
    last_updated_date  TIMESTAMP   NOT NULL
);