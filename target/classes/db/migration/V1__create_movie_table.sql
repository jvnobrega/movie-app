CREATE TABLE movie
(
    id                 serial PRIMARY KEY,
    uuid               varchar(36)  NOT NULL,
    title              varchar(30)  NOT NULL,
    genre              varchar(40)  NULL,
    story_line         varchar(260) NULL,
    release_date       date        NOT NULL,
    version            integer     NOT NULL,
    input_date         TIMESTAMP   NOT NULL,
    last_updated_date  TIMESTAMP   NOT NULL
);