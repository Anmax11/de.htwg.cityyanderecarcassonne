package de.htwg.cityyanderecarcassonne;

import java.io.IOException;
import java.util.Scanner;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.view.gui.GraphicalUI;
import de.htwg.cityyanderecarcassonne.view.tui.TextUI;

public final class Carcassonne {
	
	private static ICarcassonneController controller;
	private static TextUI tui;
	private static Scanner in;
	
	private Carcassonne() {
		
	}

	public static void main(String[] args) throws IOException {		
		
		controller = new CarcassonneController(15, 15);
		tui = new TextUI(controller);
		tui.printTUI();
		
		GraphicalUI gui = new GraphicalUI(controller);
		
		boolean continu = true;
        in = new Scanner(System.in);
        while (continu) {
            continu = tui.processInput(in.next());
        }
        in.close();
        
        
	}

}
