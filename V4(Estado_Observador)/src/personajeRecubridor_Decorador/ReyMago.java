package personajeRecubridor_Decorador;

import java.awt.Image;

import personajeCompleto.PersonajeAnimado;
import personajeOrdenarConstruccion.BuilderMago;

public class ReyMago extends PersonajeComplemento{

	//Constructor
	public ReyMago(PersonajeAnimado miREY) {
		super(miREY);
		this.complementarPersonaje();
	}

	@Override
	public void complementarPersonaje() {
		BuilderMago miMago = new BuilderMago();
		directorPersonaje.construir(miMago);
		miPerTran = miMago.obtenerPerAnimado();
		miPerTran.asignarDatos();
		this.posicionX = miREY.posicionX;
		this.posicionY = miREY.posicionY;
		miREY.asigArmadura(miPerTran.getArmaduraPer());
		miREY.asigHabilidad(miPerTran.getHabilidadPer());
		miREY.asigHerramienta(miPerTran.getHerramientaPer());
		
		miREY.oficio = miPerTran.oficio;
		miREY.imgPerAni.setNombreImg(miREY.oficio);
		this.experiencia = miREY.experiencia;
	}
	//----------------------------------------------------

	@Override
	public void realizarAccion() {
		miREY.realizarAccion();
	}

	@Override
	public void asignarDesplazamiento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonajeAnimado clonarPersonaje() {
		return miREY;
	}

	@Override
	public Image imgPersonaje() {
		return miREY.imgPersonaje();
	}

	@Override
	public void asignarDatos() {		
	}
	

}
