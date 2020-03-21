package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HerramientaArqueroOro extends HerramientaPersonaje{

	public HerramientaArqueroOro() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatorHerramienta();
	}
	@Override
	public void asignarDatorHerramienta() {
		//Atributos
		nombreHerramienta = "HerramientaArcoOro";
		categoriaHerramienta = "Caballero";
		dagno = 10;
		miPlanImg.setNombreImg(nombreHerramienta);
	}

	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	@Override
	public HerramientaPersonaje clonarHerramienta() {
		HerramientaPersonaje miClon = new HerramientaArqueroOro();
		return miClon;
	}

}
