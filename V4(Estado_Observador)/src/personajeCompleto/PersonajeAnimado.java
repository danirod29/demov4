package personajeCompleto;

import java.awt.Image;

import partesPersonaje.ArmaduraPersonaje;
import partesPersonaje.HabilidadPersonaje;
import partesPersonaje.HerramientaPersonaje;
import plantillas.PlantillaCreacionImagenes;

public abstract class PersonajeAnimado {
	//Atributos
	public int posicionX = 0;
	public int posicionY = 0;
	public final int desPlazamiento = 50;
	public String oficio;
	protected int nivelDeVida;
	public int experiencia = 0;
	protected ArmaduraPersonaje armaduraPer;
	protected HerramientaPersonaje herramientaPer;
	protected HabilidadPersonaje habilidadPer;
	public PlantillaCreacionImagenes imgPerAni = new PlantillaCreacionImagenes();
	protected int acumulador=1;
	//Constructor----------------------------------------
	public PersonajeAnimado() {
		
	}
	//Metodos
	
	//.................................................. 
    //Se instancian las partes del personaje
    
    public void asigArmadura(ArmaduraPersonaje armaduraPer){
        this.armaduraPer = armaduraPer;
        if(armaduraPer!=null) {
        	experiencia = experiencia + armaduraPer.dagno;
        }
    }
    
    public void asigHerramienta(HerramientaPersonaje herramientaPer){
        this.herramientaPer = herramientaPer;
        if(herramientaPer!=null) {
        	experiencia = experiencia + herramientaPer.dagno;
        }
    }
    
    public void asigHabilidad(HabilidadPersonaje habilidadPer){
        this.habilidadPer = habilidadPer;
        if(habilidadPer!=null) {
        	experiencia = experiencia + habilidadPer.dagno;
        }
    }
    
    public void animarMuertePer() {
    }
    
    public abstract void realizarAccion();
    public  abstract void asignarDesplazamiento();
    public  void asignarDesplazamiento(int posicionX, int posiciony) {
    	this.posicionX = posicionX;
    	this.posicionY = posiciony;
    }
    public abstract PersonajeAnimado clonarPersonaje();
    public abstract Image imgPersonaje();
    public abstract void asignarDatos();

	//--------------------------------------------------------------

	public ArmaduraPersonaje getArmaduraPer() {
		return armaduraPer;
	}

	public HerramientaPersonaje getHerramientaPer() {
		return herramientaPer;
	}
	
	public HabilidadPersonaje getHabilidadPer() {
		return habilidadPer;
	}	
	

}
