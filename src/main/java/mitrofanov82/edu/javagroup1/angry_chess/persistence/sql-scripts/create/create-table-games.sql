CREATE TABLE games (
id				int				PRIMARY KEY,
user_id_white	int				NOT NULL,
user_id_black	int				NOT NULL,
game_result		varchar(18) 	NOT NULL,
FOREIGN KEY (user_id_white) REFERENCES users(id),
FOREIGN KEY (user_id_black) REFERENCES users(id)
);