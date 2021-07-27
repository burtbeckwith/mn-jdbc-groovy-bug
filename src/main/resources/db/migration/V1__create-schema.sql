CREATE TABLE game (
    id CHAR(36) PRIMARY KEY
);

CREATE TABLE game_state (
    id CHAR(36) PRIMARY KEY,
    game_id CHAR(36) NOT NULL,
    CONSTRAINT fk_game_state_game FOREIGN KEY (game_id) REFERENCES game(id)
);
