package algorytmy;

public class SCAN extends AlgorytmDostepu{
	private String kierunek = "Prawo";
	private final static String ETYKIETA = "SCAN";

	public SCAN(){
		super(ETYKIETA);
	}
	
	public void krok(){
		if(idToDo.size()>0){
			if(kierunek.equals("Prawo")){
				if(dysk.glowicaDoPrzodu()){
					
						if(idToDo.contains(dysk.pozycjaGlowicy())){
							dysk.odznaczCylinder(dysk.pozycjaGlowicy());
							idToDo.remove((Object)dysk.pozycjaGlowicy());
						}
					
				}else{
					kierunek = "Lewo";
				}
			}	
			
			if(kierunek.equals("Lewo")){
				if(dysk.glowicaDoTylu()){
					
						if(idToDo.contains(dysk.pozycjaGlowicy())){
							dysk.odznaczCylinder(dysk.pozycjaGlowicy());
							idToDo.remove((Object)dysk.pozycjaGlowicy());
						}
					
				}else{
					kierunek = "Prawo";
				}
			}
		}
		
	}
	
	public void dodajDoZrobienia(int id){	
		idToDo.add(id);
		dysk.zglosCylinder(id);
	}

}
