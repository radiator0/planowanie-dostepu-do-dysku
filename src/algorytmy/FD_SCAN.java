package algorytmy;

import dysk.*;

public class FD_SCAN extends AlgorytmDostepu{
	private final static String ETYKIETA = "FD_SCAN";

	public FD_SCAN(){
		super(ETYKIETA);
	}
	
	public void krok(){
		
		if(idToDo.size()>0){
			int glowica = dysk.pozycjaGlowicy();
			if(najkrotszy().pobierzId()>glowica){
				
				dysk.glowicaDoPrzodu();
			}else if(najkrotszy().pobierzId()<glowica){
			
				dysk.glowicaDoTylu();
			}
			idToDo.remove((Object)glowica);
			dysk.odznaczCylinder(glowica);
			
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

