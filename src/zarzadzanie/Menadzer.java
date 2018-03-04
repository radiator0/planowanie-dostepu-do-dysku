package zarzadzanie;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algorytmy.*;

public class Menadzer {
	private List<AlgorytmDostepu> algorytmy;
	private List<Integer> uzywaneId;
	
	public Menadzer(){
		algorytmy = new ArrayList<>();
		uzywaneId = new ArrayList<>();
		
		algorytmy.add(new FCFS());
		algorytmy.add(new SCAN());
		algorytmy.add(new C_SCAN());
		algorytmy.add(new SSTF());
		
		algorytmy.add(new EDF());
		algorytmy.add(new FD_SCAN());
	}
	
	public void krok(){
		for(AlgorytmDostepu a : algorytmy){
			a.krok();
		}
		if(uzywaneId.size()<200){
			probujDodac();
		}
		
	}
	
	private boolean czyUzywane(int id){
		for(int x : uzywaneId){
			if(x == id)
				return true;
		}
		return false;
	}
	
	private void probujDodac(){
		Random r = new Random();
		if(r.nextInt(1000) > 980){
			int id = r.nextInt(200);
			while(czyUzywane(id)){
				id = r.nextInt(200);
			}
			for(AlgorytmDostepu  a: algorytmy){
				a.dodajDoZrobienia(id);	
				uzywaneId.add(id);
			}
		}
	}
	
	public List<AlgorytmDostepu> pobierzAlgorytmy(){
		return algorytmy;
	}

}
