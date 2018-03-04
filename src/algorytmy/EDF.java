package algorytmy;

import dysk.*;

public class EDF extends AlgorytmDostepu{
	private final static String ETYKIETA = "EDF";

	public EDF(){
		super(ETYKIETA);
	}
	
	public void krok(){
		
		if(idToDo.size()>0){
			int glowica = dysk.pozycjaGlowicy();
			if(najkrotszy().pobierzId()>glowica){
				
				dysk.glowicaDoPrzodu();
			}else if(najkrotszy().pobierzId()<glowica){
				
				dysk.glowicaDoTylu();
			}else if(najkrotszy().pobierzId()==glowica){
			
				idToDo.remove((Object)glowica);
				dysk.odznaczCylinder(glowica);
			}
		}
	}
	
	private Cylinder najkrotszy(){
		Cylinder c = dysk.pobierzCylindry().get(idToDo.get(0));
		for(Cylinder x : dysk.pobierzCylindry()){
			if(idToDo.contains((Object)x.pobierzId())){
				if(x.pobierzCzas()<c.pobierzCzas()){
					c = x;
				}
			}
		}
		return c;
	}
	
	public void dodajDoZrobienia(int id){	
		idToDo.add(id);
		dysk.zglosCylinder(id);
	}
}

