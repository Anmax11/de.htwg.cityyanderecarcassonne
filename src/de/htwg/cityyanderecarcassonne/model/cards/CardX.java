package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.graph.AdjacencyListUndirectedGraph;
import de.htwg.cityyanderecarcassonne.model.graph.Graph;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardX implements ICard {
	
	private final IRegion leftTopOne;
	private final IRegion middleTop;
	private final IRegion rightTopOne;
	
	private final IRegion leftTopTwo;
	private final IRegion rightTopTwo;
	
	private final IRegion leftCenter;
	private final IRegion middleCenter;
	private final IRegion rightCenter;
	
	private final IRegion leftBelowTwo;
	private final IRegion rightBelowTwo;
	
	private final IRegion leftBelowOne;
	private final IRegion middleBelow;
	private final IRegion rightBelowOne;
	
	private Graph<IRegion> cardGraph;
	
	public CardX() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionStreet();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionLawn();
		
		this.leftCenter = new RegionStreet();
		this.middleCenter = new RegionCrossing();
		this.rightCenter = new RegionStreet();
		
		this.leftBelowTwo = new RegionLawn();
		this.rightBelowTwo = new RegionLawn();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionStreet();
		this.rightBelowOne = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void genCardGraph() {
		cardGraph = new AdjacencyListUndirectedGraph<>();
		
		cardGraph.addVertex(leftTopOne);
		cardGraph.addVertex(middleTop);
		cardGraph.addVertex(rightTopOne);
		cardGraph.addVertex(leftTopTwo);
		cardGraph.addVertex(rightTopTwo);
		cardGraph.addVertex(leftCenter);
		cardGraph.addVertex(middleCenter);
		cardGraph.addVertex(rightCenter);
		cardGraph.addVertex(leftBelowTwo);
		cardGraph.addVertex(rightBelowTwo);
		cardGraph.addVertex(leftBelowOne);
		cardGraph.addVertex(middleBelow);
		cardGraph.addVertex(rightBelowOne);
		
		cardGraph.addEdge(leftTopOne, middleTop);
		cardGraph.addEdge(middleTop, rightTopOne);
		cardGraph.addEdge(rightTopOne, rightTopTwo);
		cardGraph.addEdge(rightTopTwo, rightCenter);
		cardGraph.addEdge(rightCenter, rightBelowTwo);
		cardGraph.addEdge(rightBelowTwo, rightBelowOne);
		cardGraph.addEdge(rightBelowOne, middleBelow);
		cardGraph.addEdge(middleBelow, leftBelowOne);
		cardGraph.addEdge(leftBelowOne, leftBelowTwo);
		cardGraph.addEdge(leftBelowTwo, leftCenter);
		cardGraph.addEdge(leftCenter, leftTopTwo);
		cardGraph.addEdge(leftTopTwo, leftTopOne);
		
		cardGraph.addEdge(leftTopOne, leftBelowOne);
		cardGraph.addEdge(rightTopOne, rightBelowOne);
		cardGraph.addEdge(leftTopTwo, rightTopTwo);
		cardGraph.addEdge(leftBelowTwo, rightBelowTwo);
		
		cardGraph.addEdge(middleTop, middleCenter);
		cardGraph.addEdge(rightCenter, middleCenter);
		cardGraph.addEdge(middleBelow, middleCenter);
		cardGraph.addEdge(leftCenter, middleCenter);
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int streetID2 = IDManager.getStreetID();
		int streetID3 = IDManager.getStreetID();
		int streetID4 = IDManager.getStreetID();
		int crossingID1 = IDManager.getCrossingID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(streetID1);
		rightTopOne.setID(lawnID1);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(lawnID1);
		
		leftCenter.setID(streetID2);
		middleCenter.setID(crossingID1);
		rightCenter.setID(streetID3);
		
		leftBelowTwo.setID(lawnID1);
		rightBelowTwo.setID(lawnID1);
		
		leftBelowOne.setID(lawnID1);
		middleBelow.setID(streetID4);
		rightBelowOne.setID(lawnID1);
	}

	@Override
	public IRegion getLeftTopOne() {
		return leftTopOne;
	}

	@Override
	public IRegion getMiddleTop() {
		return middleTop;
	}

	@Override
	public IRegion getRightTopOne() {
		return rightTopOne;
	}

	@Override
	public IRegion getLeftTopTwo() {
		return leftTopTwo;
	}

	@Override
	public IRegion getRightTopTwo() {
		return rightTopTwo;
	}

	@Override
	public IRegion getLeftCenter() {
		return leftCenter;
	}

	@Override
	public IRegion getMiddleCenter() {
		return middleCenter;
	}

	@Override
	public IRegion getRightCenter() {
		return rightCenter;
	}

	@Override
	public IRegion getLeftBelowTwo() {
		return leftBelowTwo;
	}

	@Override
	public IRegion getRightBelowTwo() {
		return rightBelowTwo;
	}

	@Override
	public IRegion getLeftBelowOne() {
		return leftBelowOne;
	}

	@Override
	public IRegion getMiddleBelow() {
		return middleBelow;
	}

	@Override
	public IRegion getRightBelowOne() {
		return rightBelowOne;
	}

	@Override
	public Graph<IRegion> getCardGraph() {
		return cardGraph;
	}
	
	
}
