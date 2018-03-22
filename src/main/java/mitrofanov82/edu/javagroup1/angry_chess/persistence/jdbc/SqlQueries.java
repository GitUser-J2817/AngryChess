package mitrofanov82.edu.javagroup1.angry_chess.persistence.jdbc;

public class SqlQueries {
	public final static String CREATE_USERS_TABLE=
		"CREATE TABLE users (" 
			+ "id SERIAL PRIMARY KEY,"
			+ "login varchar(32) UNIQUE,"
			+ "password	varchar,"
			+ "user_name varchar(24) UNIQUE,"
			+ "rating int,"
			+ "email varchar(50) UNIQUE,"	
			+ "avatar varchar)";
	
	public final static String CREATE_GAMES_TABLE = 
			"CREATE TABLE games (" 
					+ "id SERIAL PRIMARY KEY,"
					+ "user_id_white int NOT NULL,"
					+ "user_id_black int NOT NULL,"
					+ "game_result varchar(24) NOT NULL,"
					+ "FOREIGN KEY (user_id_white) REFERENCES users(id),"
					+ "FOREIGN KEY (user_id_black) REFERENCES users(id)"	
					+ ")";
	
	public final static String INSERT_TEST_USERS=
			"INSERT INTO users (login,password, user_name) VALUES('user1','ewm9mdfde','Pit'),('user2','ptari9wde','Joe'),('user3','fsma8uwde','Bill'),('user4','ewmsdf9de','Styve'),('user5','eatgdm89d','Bob')";			
	
	public final static String INSERT_TEST_GAMES=
			"INSERT INTO games (user_id_white, user_id_black, game_result) VALUES(1,2,'W'),(2,1,'B'),(1,2,'B'),(3,5,'W'),(4,1,'W')";
	
	public final static String SAVE_GAME_SQL=
			"INSERT INTO games(user_id_white, user_id_black, game_result) values(?,?,'?')";
}
