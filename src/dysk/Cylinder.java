package dysk;
import java.awt.Color;
import java.util.Random;

public class Cylinder implements Cloneable{
	private int id;
	private Color bazowyKolor;
	private Color kolor;
	private boolean zgloszony = false;
	private int czas;
	private Random r = new Random();
	
	public Cylinder(int id, Color kolor){
		this.id = id;
		this.kolor = kolor;
		for(int i=0; i<3; i++) this.kolor = this.kolor.darker();
		this.bazowyKolor = this.kolor;
		czas =  r.nextInt(10)+1;
	}
	
	public int pobierzId(){
		return id;
	}
	
	public Color pobierzKolor(){
		return kolor;
	}
	
	public void oznacz(){
		for(int i=0; i<6; i++) kolor = kolor.brighter();
		zgloszony = true;
	}
	
	public int pobierzCzas(){
		return czas;
	}
	
	public void odznacz(){
		kolor = bazowyKolor;
		zgloszony = false;
	}
	
	public boolean czyZgloszony(){
		return zgloszony;
	}
	
	public Cylinder clone() throws CloneNotSupportedException {
        return (Cylinder)super.clone();
    }	
}
