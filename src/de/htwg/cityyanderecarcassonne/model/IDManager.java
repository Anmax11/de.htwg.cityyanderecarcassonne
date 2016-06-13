package de.htwg.cityyanderecarcassonne.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class IDManager {
	
	private static Set<Integer> idpool = new HashSet<>();
	private static int buildingID  = 10000;
	private static int crossingID = 20000;
	private static int lawnID = 30000;
	private static int schoolID = 40000;
	private static int streetID = 50000;
	
	private static Map<Integer, List<Player>> idPlayer = new HashMap<>();
	
	private IDManager() {
		throw new UnsupportedOperationException();
	}
	
	public static int getBuildingID() {
		int r = buildingID;
		addID(r);
		buildingID++;
		return r;
	}
	
	public static int getCrossingID() {
		int r = crossingID;
		addID(r);
		crossingID++;
		return r;
	}
	
	public static int getLawnID() {
		int r = lawnID;
		addID(r);
		lawnID++;
		return r;
	}
	
	public static int getSchoolID() {
		int r = schoolID;
		addID(r);
		schoolID++;
		return r;
	}
	
	public static int getStreetID() {
		int r = streetID;
		addID(r);
		streetID++;
		return r;
	}
	
	private static void addID(int id) {
		idpool.add(id);
		idPlayer.put(id, new LinkedList<>());
	}
	
	public static boolean idUsed(int id) {
		return idpool.contains(id);
	}
	
	public static void resetIDCount()	{
		idpool.clear();
		buildingID  = 10000;
		crossingID = 20000;
		lawnID = 30000;
		schoolID = 40000;
		streetID = 50000;
		
		//TODO: Also idPlayer reset? Rename method to reset?
	}
	
	public static boolean setPlayer(int id, Player player) {
		if (idpool.contains(id)) {
			List<Player> playerList = idPlayer.get(id);
			if (!playerList.contains(player)) {
				playerList.add(player);
				return true;
			}
		}
		return false;
	}
	
	public static boolean isOwned(int id) {
		if (idpool.contains(id)) {
			return !idPlayer.get(id).isEmpty();
		}
		return false;
	}
	
	public static List<Player> getPlayerList(int id) {
		return idPlayer.get(id);
	}
}
