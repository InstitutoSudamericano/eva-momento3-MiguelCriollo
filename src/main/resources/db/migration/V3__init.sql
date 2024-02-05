CREATE TABLE IF NOT EXISTS character_scene(
        id SERIAL,
    character_minutes INT,
    character_id INT,
    scene_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (character_id) REFERENCES character(id),
    FOREIGN KEY (scene_id) REFERENCES scene(id)
);
