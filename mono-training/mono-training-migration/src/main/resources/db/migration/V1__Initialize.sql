CREATE TABLE users (
    id serial NOT NULL,
    name VARCHAR(100) NOT NULL,
    ${commonColumns},
    CONSTRAINT user_pk PRIMARY KEY (id)
);
