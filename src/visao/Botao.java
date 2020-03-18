package visao; //captura os eventos de click 

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.Campo;

@SuppressWarnings("serial")
public class Botao extends JButton implements MouseListener {
	private Campo campo;
	public Botao(Campo campo) {
		
		 
		this.campo = campo;
		addMouseListener(this);
		
		
		setIcon(new ImageIcon(getClass().getResource("/visao/recursos/mar.png")));
		
		setBackground(new Color(47, 86, 215));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			int resultado = campo.abrirCampo();
			if (resultado == 1) {
				setIcon(new ImageIcon(getClass().getResource("/visao/recursos/boom.gif")));
			} else if (resultado == 0) {
				setIcon(new ImageIcon(getClass().getResource("/visao/recursos/erro.png")));
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
