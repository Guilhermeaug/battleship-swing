package visao; //Conteiner dos botoes 

import java.awt.GridLayout;

import javax.swing.JPanel;

import modelo.Tabuleiro;

@SuppressWarnings("serial")
public class Cena extends JPanel {

	public Cena(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(10, 10));

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				add(new Botao(tabuleiro.matriz[i][j]));
			}
		}
	}
}
