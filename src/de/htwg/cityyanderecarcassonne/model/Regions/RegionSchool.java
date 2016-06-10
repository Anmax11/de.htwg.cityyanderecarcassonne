package de.htwg.cityyanderecarcassonne.model.Regions;

import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.RegionInterface;

public class RegionSchool implements RegionInterface {
	
	private String typename;
	private Player player;
	private int id;
	
	public RegionSchool() {
		this.typename = "School";
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public void setID(int id) {
		this.id = id;
	}

	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Type: " + typename + "Player: " + player + "ID: " + id;
	}
}
