package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import modelo.ObservadorTabuleiroResultado;
import modelo.Tabuleiro;

@SuppressWarnings("serial")
public class BatalhaNaval extends JFrame implements ObservadorTabuleiroResultado {
	public BatalhaNaval(int misseis) {
		Tabuleiro tabuleiro = new Tabuleiro(misseis);
		tabuleiro.adicionarObservador(this);
		
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

	@Override
	public void notificar(Tabuleiro tabuleiro, boolean resultado) {
		//O jogador ganhou ou perdeu. Fim da história.
		dispose();
		System.out.println("Cheguei aqui!");
		
		if(resultado) {
			new TerceiraTela(true);
		} else {
			new TerceiraTela(false);
		}
	}

}
