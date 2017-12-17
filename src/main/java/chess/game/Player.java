package chess.game;

public class Player {
	private static long idGenerator = 1;
	private long idPlayer = 0;
	private String namePlayer = "";

	public Player(String namePlayer) {
		this.namePlayer = namePlayer;
		this.idPlayer = idGenerator++;
	}

	

	public long getIdPlayer() {
		return idPlayer;
	}

	public String getNamePlayer() {
		return namePlayer;
	}

}
