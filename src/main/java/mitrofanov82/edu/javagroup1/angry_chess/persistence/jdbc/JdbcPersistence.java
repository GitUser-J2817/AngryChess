package mitrofanov82.edu.javagroup1.angry_chess.persistence.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.persistence.IChessPersistenceAPI;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGameHistory;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class JdbcPersistence implements IChessPersistenceAPI {
	
	
	private String dbUrl = "jdbc:postgresql://localhost:5432/Chess";
	private String user = "postgres";
	private String password = "admin";
	
	Connection conn;
	
	public JdbcPersistence(boolean createTables) throws Exception{
		conn = java.sql.DriverManager.getConnection(dbUrl, user, password);
		//System.out.println(conn.getAutoCommit());
		//System.out.println(conn.getCatalog());
		//System.out.println(conn.getClientInfo());
		//System.out.println(conn.getMetaData());
		if (createTables){
			Statement statement = conn.createStatement();
			statement.execute(SqlQueries.CREATE_USERS_TABLE);
			statement.execute(SqlQueries.CREATE_GAMES_TABLE);
			statement.execute(SqlQueries.INSERT_TEST_USERS);
			statement.execute(SqlQueries.INSERT_TEST_GAMES);
		}
	}

	@Override
	public void saveGameResults(IGame game) throws Exception {
		// TODO Auto-generated method stub
		Statement statement = conn.createStatement();
		//1. Достать айди двух игроков по имени
		String selectWhiteIdSQL = "SELECT id from users "
				+ "where user_name='" 
				+ game.getWhitePlayer().getName() 
				+ "'";
		//System.out.println(selectWhiteIdSQL);
		ResultSet whiteRS = statement.executeQuery(selectWhiteIdSQL);
		System.out.println(whiteRS.next());
		long whiteId = whiteRS.getLong("id");
		ResultSet blackPlayerId = statement.executeQuery("SELECT id from users "
				+ "where user_name='" 
				+ game.getBlackPlayer().getName() 
				+ "'");
		blackPlayerId.next();
		long blackId = blackPlayerId.getLong("id");
		System.out.println("whiteId="+whiteId + "  bId=" + blackId);
		
		String saveSql = SqlQueries.SAVE_GAME_SQL;
		saveSql = saveSql.replaceFirst("\\?", Long.toString(whiteId));
		saveSql = saveSql.replaceFirst("\\?", Long.toString(blackId));
		saveSql = saveSql.replaceFirst("\\?", game.getGameStatus().toString());
		System.out.println(saveSql);
		statement.executeUpdate(saveSql);
		
	}

	@Override
	public List<IGameHistory> getGamesHistory() {
		// TODO Auto-generated method stub
		return new ArrayList();
	}

	@Override
	public List<IGameHistory> getGamesHistory(IPlayer p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IGameHistory> getGamesHistory(IPlayer p1, IPlayer p2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPlayer> getAllRegisteredPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
