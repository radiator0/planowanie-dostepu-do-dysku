package wyswietlanie;
import java.awt.*;
import javax.swing.JPanel;
import algorytmy.*;
import dysk.*;
import zarzadzanie.*;
public class Panel extends JPanel {
	private static final long serialVersionUID = -8378771651986102384L;
	private Menadzer m;
	public Panel(Menadzer m) {
		this.m  = m;
		setPreferredSize(new Dimension(1040, 630));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawString("Copyright "+"\u00a9"+" 2017 Krzysztof Pilarczyk. All rights reserved.", 20, 620);
		
		int width = 5;
		int odstep = 0;
		for(AlgorytmDostepu algorytm : m.pobierzAlgorytmy()){
			int krok = algorytm.pobierzGlowice();
			int tabx[] = new int[]{krok*width+20, krok*width+15, krok*width+30, krok*width+40};
			int taby[] = new int[]{25+odstep,25+odstep,0+odstep,0+odstep};
			g2d.setColor(Color.GRAY);
			g2d.fillPolygon(tabx, taby, 4);
			g2d.setColor(Color.BLACK);	
			g2d.drawString(algorytm.pobierzEtykiete(), 20, 87+odstep);
			g2d.drawString("POZYCJA GŁOWICY: " + krok, 100,87+odstep);
			g2d.drawString("ILOSC RUCHÓW GŁOWICY: " + algorytm.pobierzIloscRuchowGlowicy(), 400,87+odstep);
			g2d.drawString("DŁUGOSC KOLEJKI: " + algorytm.pobierzIloscZadan(), 700,87+odstep);
			
			int i = 0;
			for(Cylinder c : algorytm.pobierzCylindry()){
				// Pierwszy prostokąt pod spodem, ktory ma ustawioną przeźroczystość
				g2d.setColor(Color.WHITE);
				g2d.fillRect(i*width +20, 25 + odstep, width, 50);
				
				// Prostokąt właściwy
				g2d.setColor(c.pobierzKolor());
				if(algorytm.czyWyswietlacCzas() && c.czyZgloszony()){
					
					g2d.fillRect(i*width +20, 25 + odstep, width, c.pobierzCzas()*5);
				}else{
					
					g2d.fillRect(i*width +20, 25 + odstep, width, 50);
				}
				i++;
			}
			
			odstep +=100;
		}
	
		
	}
}