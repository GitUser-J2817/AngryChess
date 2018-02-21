package tests_from_model;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class TSMPlayer implements IPlayer {
	private String name;
	private int rating;
	
	public TSMPlayer(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

}
