package wyswietlanie;
import javax.swing.*;

import zarzadzanie.Menadzer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ramka extends JFrame {
	/** Czas w jakim wyswietlany jest jeden cykl na ekranie w ms*/
	private final int interwalOdswiezania=10;
	/** Deklaracja panelu */
	JPanel panel;
	Menadzer m;
	
	public Ramka() {
		super("Algorytmy planowania dostępu do dysku");
		m = new Menadzer();
		panel = new Panel(m);
		add(panel);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);		
	}

	/**
	 * Metoda pozwala na odswiezenie ekranu
	 */
	public void odswiez(){
		panel.repaint();
		panel.revalidate();
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {	
				Ramka f = new Ramka();			
				final Timer timer = new Timer(f.interwalOdswiezania, new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						f.odswiez();
						f.m.krok();
					}
				
				 });
				 timer.start();
			}
		});
	}
	private static final long serialVersionUID = -2122161377842820073L;
}