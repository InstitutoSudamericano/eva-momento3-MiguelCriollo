CREATE TABLE IF NOT EXISTS scene(
        id SERIAL,
    title VARCHAR (100),
    description VARCHAR(300),
    budget DECIMAL(10, 2),
    minutes INT,
    film_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES film(id)
);

CREATE TABLE IF NOT EXISTS character(
        id SERIAL,
    name VARCHAR(200),
    actor VARCHAR(200),
    description VARCHAR(300),
    price_minute DECIMAL(10,2),
    scene_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (scene_id) REFERENCES scene(id)
)
