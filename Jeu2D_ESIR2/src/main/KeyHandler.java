package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Gestionnaire d'�v�nements (touche clavier)
 *
 */
public class KeyHandler implements KeyListener{

	private int m_keyCode;
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// r�cup�re le code du boutton appuy�
		int code = e.getKeyCode();
		m_keyCode = code;
		System.out.println(code);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		m_keyCode=0;
	}

	public int getKeyCode() {
		return m_keyCode;
	}
}
