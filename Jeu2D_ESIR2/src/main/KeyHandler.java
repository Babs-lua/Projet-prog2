package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Gestionnaire d'�v�nements (touche clavier)
 *
 */
public class KeyHandler implements KeyListener {

	Set<Integer> key;

	KeyHandler() {
		key = new HashSet<Integer>();
	}

	public Set<Integer> getKey() {
		return key;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// r�cup�re le code du boutton appuy�
		int code = e.getKeyCode();

		key.add(code);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key.remove(e.getKeyCode());
	}

}
