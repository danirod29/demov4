package personajeCompleto;

import java.awt.Image;

import personajeOrdenarConstruccion.*;

public class PersonajeRey extends PersonajeAnimado{

	@Override
	public void realizarAccion() {
		if(acumulador == 1) {
			imgPerAni.numImg = "1";
		}else {
			imgPerAni.numImg = "2";
			acumulador = 0;
		}
		acumulador ++;
	}

	@Override
	public PersonajeAnimado clonarPersonaje() {
		PersonajeAnimado miClonRey;
        
        //Se Determinan las partes del Mago
        Director miDirector = new Director();
        BuilderRey miBuilderRey = new BuilderRey();
        
        miDirector.construir(miBuilderRey);
        
        //Se instancia el objeto para que sea Mago
        miClonRey = miBuilderRey.obtenerPerAnimado();
        miClonRey.asignarDesplazamiento(this.posicionX, this.posicionY+50);
        miClonRey.asignarDatos();
        //Metodos que reciben parametros
		return miClonRey;
	}

	@Override
	public Image imgPersonaje() {
		return imgPerAni.getImagenMov2();
	}

	@Override
	public void asignarDatos() {
		this.oficio = "Rey";
		this.nivelDeVida = 300;
		this.imgPerAni.setNombreImg(oficio);
	}
	
	@Override
	public void asignarDesplazamiento() {
	}
	public void utilizarHabilidadActual() {
		
	}

}
