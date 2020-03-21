package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HabilidadMagoHielo extends HabilidadPersonaje{

	public HabilidadMagoHielo() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadHielo";
		categoriaHabilidad = "Mago";
		dagno = 9;
		miPlanImg.setNombreImg(nombreHabilidad);;
		
	}

	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	@Override
	public HabilidadPersonaje clonarHabilidad() {
		HabilidadPersonaje miClo = new HabilidadMagoHielo();
		return miClo;
	}
}
