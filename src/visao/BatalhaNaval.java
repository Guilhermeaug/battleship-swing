package visao; //Cria um tabuleiro , cria os botoes

import modelo.ObservadorTabuleiroResultado;
import modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BatalhaNaval extends JFrame implements ObservadorTabuleiroResultado {
	public BatalhaNaval(int misseis) {
		Tabuleiro tabuleiro = new Tabuleiro(misseis);
		tabuleiro.adicionarObservador(this);
		
		
		
		JButton imgEixoX = new JButton();
		imgEixoX.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/Linha.jpg")));
		
		imgEixoX.setOpaque(false);
		imgEixoX.setContentAreaFilled(false);
		imgEixoX.setBorderPainted(false);
		

		
		JButton imgEixoY = new JButton();
		imgEixoY.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/coluna.jpg")));
		
		imgEixoY.setOpaque(false);
		imgEixoY.setContentAreaFilled(false);
		imgEixoY.setBorderPainted(false);
			
		imgEixoY.setMinimumSize(new Dimension(48, 480));
		imgEixoY.setPreferredSize(new Dimension(48, 480));
		imgEixoY.setMaximumSize(new Dimension(48, 480));
		
		add(imgEixoX, BorderLayout.NORTH);
		add(imgEixoY, BorderLayout.WEST);
		
		Cena cena = new Cena(tabuleiro);
		cena.setPreferredSize(new Dimension(100, 100));
		add(cena, BorderLayout.CENTER);

		Cena2 cena2 = new Cena2(tabuleiro);
		cena2.setPreferredSize(new Dimension(50, 50));
		add(cena2, BorderLayout.SOUTH);
		

		setTitle("Batalha Naval");
		setSize(550,630);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	@Override
	public void notificar(Tabuleiro tabuleiro, boolean resultado) {
		//O jogador ganhou ou perdeu. Fim da hist�ria.
		dispose();
		System.out.println("Cheguei aqui!");
		
		if(resultado) {
			new TerceiraTela(true);
		} else {
			new TerceiraTela(false);
		}
	}

}
