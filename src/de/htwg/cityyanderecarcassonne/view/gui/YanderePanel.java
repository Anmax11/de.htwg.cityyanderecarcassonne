package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.view.StatusMessage;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class YanderePanel extends JPanel implements IObserver {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	private StatusMessage sm;
	
	private SpringLayout yandereLayout;
	private JTextArea textArea;
	
	public YanderePanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.sm = new StatusMessage();
		controller.addObserver(this);
		
		textArea = new JTextArea(5, 5);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(250,150));
		
		yandereLayout = new SpringLayout();
		yandereLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, contentPane);
		yandereLayout.putConstraint(SpringLayout.NORTH, scrollPane, 50, SpringLayout.NORTH, contentPane);
		this.setLayout(yandereLayout);
	    contentPane.revalidate();
	    
	    this.add(scrollPane);
		
	    this.setPreferredSize(new Dimension(250,350));
	    this.setBackground(Color.GRAY);
	    this.setVisible(true);
	}

	@Override
	public void update(Event e) {
		textArea.setText(sm.getStatusMessage(controller.getStatus()) + controller.getStatusMessage());
	}
}
