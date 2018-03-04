package algorytmy;

public class FCFS extends AlgorytmDostepu{
	private static final String ETYKIETA = "FCFS";

	public FCFS(){
		super(ETYKIETA);
	}
	
	public void krok(){
		
		if(idToDo.size()>0){
			int nastepny = idToDo.get(0);
			if( nastepny == dysk.pozycjaGlowicy()){
				idToDo.remove(0);
				dysk.odznaczCylinder(nastepny);
			}else{
				// trzeba wybrac kierunek w ktorym ma isc glowica
				if(nastepny > dysk.pozycjaGlowicy()){
					dysk.glowicaDoPrzodu();
				}else{
					dysk.glowicaDoTylu();
				}
			}
		}
	}
	
	public void dodajDoZrobienia(int id){	
		idToDo.add(id);
		dysk.zglosCylinder(id);
	}

}
