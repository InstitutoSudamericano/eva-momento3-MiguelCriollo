CREATE TABLE IF NOT EXISTS film(
    id SERIAL,
    title VARCHAR (100),
    director VARCHAR (100),
    duration INT,
    budget DECIMAL(10,2),
    PRIMARY KEY (id)
);
