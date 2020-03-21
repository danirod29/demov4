package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventoTeclado extends KeyAdapter{
	public static boolean IZQUIERDA, DERECHA, ARRIBA, ABAJO;
	public static boolean TOMARobjA, TOMAobjS;
	
	public void keyPressed(KeyEvent e) {		
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_LEFT) {
			IZQUIERDA = true;
		}
		if(id == KeyEvent.VK_RIGHT) {
			DERECHA = true;
		}
		if(id  == KeyEvent.VK_UP) {
			ARRIBA = true;
		}
		if(id == KeyEvent.VK_DOWN) {
			ABAJO = true;
		}
		if(id == KeyEvent.VK_A) {
			TOMARobjA = true;
		}
		if(id == KeyEvent.VK_S) {
			TOMAobjS = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_LEFT) {
			IZQUIERDA = false;
		}
		if(id == KeyEvent.VK_RIGHT) {
			DERECHA = false;
		}
		if(id  == KeyEvent.VK_UP) {
			ARRIBA = false;
		}
		if(id == KeyEvent.VK_DOWN) {
			ABAJO = false;
		}
		if(id == KeyEvent.VK_A) {
			TOMARobjA = false;
		}
		if(id == KeyEvent.VK_S) {
			TOMAobjS = false;
		}
	}

}
