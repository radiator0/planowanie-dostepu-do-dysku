package dysk;
import java.util.List;
import java.awt.Color;
import java.util.ArrayList;
public class Dysk {
	private final int rozmiar = 200;
	private int glowica=0;
	private int ruchGlowicy=0;
	private List<Cylinder> cylindry;
	public Dysk(){
		cylindry = new ArrayList<>();
		try {
			generujCylindry();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	public void generujCylindry() throws CloneNotSupportedException{
		for(int i=0; i<rozmiar; i++){
			Color kolor = new Color(((i%100)%11 *15)%255, ((i%100)%7 *17)%255,((i%100)%4 *19+10)%255);
			cylindry.add(new Cylinder(i,kolor).clone());
		}
	}
	
	public void zglosCylinder(int id){
		for(Cylinder c : cylindry){
			if(c.pobierzId() == id){
				c.oznacz();
			}
		}
	}
	
	public void odznaczCylinder(int id){
		for(Cylinder c : cylindry){
			if(c.pobierzId() == id){
				c.odznacz();
			}
		}		
	}
	
	public int pozycjaGlowicy(){
		return glowica;
	}
	
	public int iloscRuchowGlowicy(){
		return ruchGlowicy;
	}
	
	public boolean glowicaDoPrzodu(){
		if(glowica<rozmiar){
			++glowica;
			++ruchGlowicy;
			return true;
		}
		return false;
	}
	
	public boolean glowicaDoTylu(){
		if(glowica>0){
			--glowica;
			++ruchGlowicy;
			return true;
		}
		return false;
	}
	
	public List<Cylinder> pobierzCylindry(){
		return cylindry;
	}
}
