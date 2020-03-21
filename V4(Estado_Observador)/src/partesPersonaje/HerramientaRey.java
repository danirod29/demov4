package partesPersonaje;

import java.awt.Image;

public class HerramientaRey extends HerramientaPersonaje {
	 public HerramientaRey() {
		this.asignarDatorHerramienta();
	}

	@Override
	public void asignarDatorHerramienta() {
		//Atributos
		nombreHerramienta = "EspadaOro";
		categoriaHerramienta = "Rey";
		dagno = 3;
	}

	@Override
	public Image retornarImagen() {
		return null;
	}

	@Override
	public HerramientaPersonaje clonarHerramienta() {
		return null;
	}

}
