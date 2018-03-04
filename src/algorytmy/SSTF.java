package algorytmy;

public class SSTF extends AlgorytmDostepu{
	private final static String ETYKIETA = "SSTF";

	public SSTF(){
		super(ETYKIETA);
	}
	
	public void krok(){
		
		if(idToDo.size()>0){
			int glowica = dysk.pozycjaGlowicy();
			if(najblizsza(glowica)>glowica){
				dysk.glowicaDoPrzodu();
			}else if(najblizsza(glowica)<glowica){
				dysk.glowicaDoTylu();
			}else if(najblizsza(glowica)==glowica){
				idToDo.remove((Object)glowica);
				dysk.odznaczCylinder(glowica);
			}
		}
	}
	
	private int najblizsza(int id){
		int najblizszy = idToDo.get(0);
		for(Integer i: idToDo){
			if(Math.abs(najblizszy-id)>Math.abs(i-id)){
				najblizszy = i;
			}
		}
		
		return najblizszy;
	}
	
	public void dodajDoZrobienia(int id){	
		idToDo.add(id);
		dysk.zglosCylinder(id);
	}

}

