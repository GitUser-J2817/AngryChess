SELECT games.* FROM games JOIN users
ON users.id=games.user_id_white
OR users.id=games.user_id_black
WHERE users.id=1;