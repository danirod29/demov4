package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HabilidadMagoFuego extends HabilidadPersonaje{
	public HabilidadMagoFuego() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadFuego";
		categoriaHabilidad = "Mago";
		dagno = 13;
		miPlanImg.setNombreImg(nombreHabilidad);;
	}

	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	@Override
	public HabilidadPersonaje clonarHabilidad() {
		HabilidadPersonaje miClo = new HabilidadMagoFuego();
		return miClo;
	}

}
