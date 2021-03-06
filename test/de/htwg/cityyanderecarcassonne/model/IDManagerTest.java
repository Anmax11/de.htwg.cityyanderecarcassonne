package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.htwg.cityyanderecarcassonne.model.impl.Player;

public class IDManagerTest {

	@Rule
	public ExpectedException uoe = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		IDManager.resetIDManager();
	}
	
	/*
	@Test
	public void testPrivateConstructor() throws UnsupportedOperationException, Exception {
		Constructor<IDManager> c = IDManager.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(c.getModifiers()));
		
		c.setAccessible(true);
		uoe.expect(InvocationTargetException.class);
		c.newInstance();
	}
	*/

	@Test
	public void testGetBuildingID() {
		assertEquals(10000, IDManager.getBuildingID());
		assertEquals(10001, IDManager.getBuildingID());
	}

	@Test
	public void testGetCrossingID() {
		assertEquals(20000, IDManager.getCrossingID());
		assertEquals(20001, IDManager.getCrossingID());
	}

	@Test
	public void testGetLawnID() {
		assertEquals(30000, IDManager.getLawnID());
		assertEquals(30001, IDManager.getLawnID());
	}

	@Test
	public void testGetSchoolID() {
		assertEquals(40000, IDManager.getSchoolID());
		assertEquals(40001, IDManager.getSchoolID());
	}

	@Test
	public void testGetStreetID() {
		assertEquals(50000, IDManager.getStreetID());
		assertEquals(50001, IDManager.getStreetID());
	}

	@Test
	public void testIdUsed() {
		IDManager.getBuildingID();
		IDManager.getLawnID();
		IDManager.getLawnID();
		assertTrue(IDManager.idUsed(10000));
		assertTrue(IDManager.idUsed(30001));
	}

	@Test
	public void testResetIDCount() {
		IDManager.resetIDManager();
		assertEquals(50000, IDManager.getStreetID());
		assertFalse(IDManager.idUsed(30001));
	}
	
	@Test
	public void setPlayerTest() {
		int id = IDManager.getBuildingID();
		IPlayer player1 = new Player("Hans");
		IPlayer player2 = new Player("Gundula");
		
		assertTrue(IDManager.setPlayer(id, player1));
		assertTrue(IDManager.setPlayer(id, player1));
		assertTrue(IDManager.setPlayer(id, player2));
		
		assertFalse(IDManager.setPlayer(12, player1));
	}
	
	@Test
	public void isOwnedTest() {
		int id1 = IDManager.getBuildingID();
		int id2 = IDManager.getBuildingID();
		IPlayer player1 = new Player("Yuuki Asuna");
		IPlayer player2 = new Player("Kirigaya Kazuto");
		// Write a PM if you know these two ;D
		
		assertTrue(IDManager.setPlayer(id1, player1));
		assertTrue(IDManager.setPlayer(id1, player2));
		assertFalse(IDManager.setPlayer(id1, null));
		
		assertTrue(IDManager.isOwned(id1));
		assertFalse(IDManager.isOwned(id2));
		
		assertFalse(IDManager.isOwned(10));
	}
	
	@Test
	public void getPlayerListTest() {
		int id1 = IDManager.getBuildingID();
		int id2 = IDManager.getLawnID();
		IPlayer player1 = new Player("Max");
		IPlayer player2 = new Player("B�rbel");
		
		IDManager.setPlayer(id1, player1);
		IDManager.setPlayer(id1, player2);
		IDManager.setPlayer(id2, player1);
		
		assertEquals("[Max, B�rbel]", IDManager.getPlayerList(id1).toString());
		assertEquals("[Max]", IDManager.getPlayerList(id2).toString());
		
		assertEquals(null, IDManager.getPlayerList(32));
	}
	
	@Test
	public void getSumCardsTest() {
		int id1 = IDManager.getBuildingID();
		
		assertTrue(IDManager.setSumCards(id1, 3));
		assertFalse(IDManager.setSumCards(10, 4));
		assertFalse(IDManager.setSumCards(id1, -1));
		
		assertEquals(3, IDManager.getSumCards(id1));
	}
	
	@Test
	public void isAreaClosedTest() {
		int id1 = IDManager.getBuildingID();
		
		assertTrue(IDManager.setAreaClosed(id1));
		assertFalse(IDManager.setAreaClosed(55));
		
		assertTrue(IDManager.isAreaClosed(id1));
		assertFalse(IDManager.isAreaClosed(33));
	}

}
