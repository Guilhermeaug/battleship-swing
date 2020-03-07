package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import modelo.Tabuleiro;

@SuppressWarnings("serial")
public class BatalhaNaval extends JFrame {
	public BatalhaNaval() {
		Tabuleiro tabuleiro = new Tabuleiro(100);

		Cena cena = new Cena(tabuleiro);
		cena.setPreferredSize(new Dimension(100, 100));
		add(cena, BorderLayout.CENTER);

		Cena2 cena2 = new Cena2(tabuleiro);
		cena2.setPreferredSize(new Dimension(50, 50));
		add(cena2, BorderLayout.SOUTH);
		

		setTitle("Batalha Naval");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new BatalhaNaval();
		
	}
}
