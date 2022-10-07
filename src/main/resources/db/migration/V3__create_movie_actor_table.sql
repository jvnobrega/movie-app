CREATE TABLE movie_actor
(
    movie_id        BIGINT NOT NULL REFERENCES movie(id),
    actor_id        BIGINT NOT NULL REFERENCES actor(id)
);