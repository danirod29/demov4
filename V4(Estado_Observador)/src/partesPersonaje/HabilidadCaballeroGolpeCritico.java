package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HabilidadCaballeroGolpeCritico extends HabilidadPersonaje{
	public HabilidadCaballeroGolpeCritico() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadGolpeCritico";
		categoriaHabilidad = "Caballero";
		dagno = 15;
		miPlanImg.setNombreImg(nombreHabilidad);;
	}

	@Override
	public Image retornarImagen() {
		return miPlanImg.getImagenMov2();
	}
	@Override
	public HabilidadPersonaje clonarHabilidad() {
		HabilidadPersonaje miClo = new HabilidadCaballeroGolpeCritico();
		return miClo;
	}

}
