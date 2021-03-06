package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardB extends MasterCard {
	
	public CardB() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionLawn();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionLawn();
		this.centerMiddle = new RegionSchool();
		this.rightMiddle = new RegionLawn();
		
		this.leftBelow = new RegionLawn();
		this.rightBelow = new RegionLawn();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionLawn();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID = IDManager.getLawnID();
		int schoolID = IDManager.getSchoolID();
		
		topLeft.setID(lawnID);
		topMiddle.setID(lawnID);
		topRight.setID(lawnID);
		
		leftTop.setID(lawnID);
		rightTop.setID(lawnID);
		
		leftMiddle.setID(lawnID);
		centerMiddle.setID(schoolID);
		rightMiddle.setID(lawnID);
		
		leftBelow.setID(lawnID);
		rightBelow.setID(lawnID);
		
		belowLeft.setID(lawnID);
		belowMiddle.setID(lawnID);
		belowRight.setID(lawnID);
	}
}
