package elementosEscenario_Composite;

import java.awt.Graphics;

public class DibujoComposicionBosque extends DibujoComposicion{
    //Permite crear un Escenario-Bosque
    //Atributos
	protected DibujoEspecificoArbol miArbol;
	protected DibujoEspecifico miClon;
	protected int  posicionX;
	protected int posicionY;
	
	//Constructor
	public DibujoComposicionBosque() {
		//Crea una lista con las partes del Bosque
		agregarArbolPequeño();
		agregarArbolPeClon();
		//Delimita la lista
		elementosDibujo.trimToSize();
	}
    //................................................................
	//Metodos propios de la clase 
	
	//Crea objeto arbol-pequeño
    public void agregarArbolPequeño(){
        miArbol = new DibujoEspecificoArbol();
        //Agrega el objeto a la lista
        this.agregarElementoComposicion(miArbol);
    }
    
    //Crea 16 objetos arboles-pequeños(CLONES)
    public void agregarArbolPeClon(){
        for(int contador=0 ; contador<38; contador++){
            miClon = (DibujoEspecifico) miArbol.clonarComponente();
            //Agrega el objeto a la lista
            this.agregarElementoComposicion(miClon);
        }
    }
    
    //................................................................
  	//Metodos heredados
	@Override
	public DibujoComponente clonarComponente() {
		// TODO Auto-generated method stub
		return null;
	}
   
}

