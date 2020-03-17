package visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import modelo.Campo;

@SuppressWarnings("serial")
public class Botao extends JButton implements MouseListener {
	private Campo campo;

	public Botao(Campo campo) {
		this.campo = campo;
		addMouseListener(this);

		setBackground(new Color(127, 255, 212));

		if (campo.getContemNavio() != 0) {
			setBackground(new Color(127, 255, 212));
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			int resultado = campo.abrirCampo();
			if (resultado == 1) {
				setBackground(new Color(0, 100, 0));
			} else if (resultado == 0) {
				setBackground(new Color(0, 0, 100));
			}
			
		}
	}

	
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
