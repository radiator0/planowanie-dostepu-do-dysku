package algorytmy;
import java.util.LinkedList;
import java.util.List;
import dysk.Cylinder;
import dysk.Dysk;

public abstract class AlgorytmDostepu {
	protected Dysk dysk;
	protected List<Integer> idToDo;
	private String etykieta;

	public AlgorytmDostepu(String etykieta){
		this.etykieta = etykieta;
		idToDo = new LinkedList<>();
		dysk = new Dysk();
	}

	public abstract void krok();
	public abstract void dodajDoZrobienia(int id);

	public int pobierzIloscRuchowGlowicy(){
		return dysk.iloscRuchowGlowicy();
	}
	public int pobierzGlowice(){
		return dysk.pozycjaGlowicy();
	}
	public List<Cylinder> pobierzCylindry(){
		return dysk.pobierzCylindry();
	}
	public int pobierzIloscZadan(){
		return idToDo.size();
	}
	public boolean czyWyswietlacCzas(){return true;}
	public String pobierzEtykiete() {
		return etykieta;
	}
}
