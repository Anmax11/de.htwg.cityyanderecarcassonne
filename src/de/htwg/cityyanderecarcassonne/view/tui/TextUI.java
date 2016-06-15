package de.htwg.cityyanderecarcassonne.view.tui;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	
	private CarcassonneController controller;
	
	public TextUI (CarcassonneController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}

	@Override
	public void update(Event e) {
		printTUI();
	}
	
	public void printTUI() {
		System.out.println(controller.getTownsquareString());
		System.out.println();
		System.out.println("Status: " + controller.getStatusMessage());
	}

}
