package partesPersonaje;

import java.awt.Image;

public class HerramientaRecolector extends HerramientaPersonaje {
	public HerramientaRecolector() {
		this.asignarDatorHerramienta();
	}

	@Override
	public void asignarDatorHerramienta() {
		//Atributos
		nombreHerramienta = "Canasto";
		categoriaHerramienta = "Recolector";
		dagno = 1;
	}

	@Override
	public Image retornarImagen(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HerramientaPersonaje clonarHerramienta() {
		HerramientaPersonaje miClon = new HerramientaRecolector();
		return miClon;
	}
	

}
