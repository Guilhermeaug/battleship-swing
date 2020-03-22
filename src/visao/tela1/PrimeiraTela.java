package visao.tela1;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import estrutura.Audio;

@SuppressWarnings("serial")
public class PrimeiraTela extends JFrame {
	JLabel imgLabel = new JLabel();

	public PrimeiraTela() {

		// Som de fundo que toca durante o jogo
		Audio song = new Audio();
		song.tocarAudio("src/Audio/MissaoImpossivel.wav");

		// JLabel com as opcoes
		InformacoesPrimeiraTela informacoes = new InformacoesPrimeiraTela(this);

		Color minhaCor = new Color(255, 255, 255);

		// Adicionando a imagem de fundo
		imgLabel.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/background.png")));
		add(imgLabel, BorderLayout.NORTH);

		// Parte de baixo do layout
		add(informacoes, BorderLayout.CENTER);

		setTitle("Batalha Naval");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setBackground(minhaCor);
		pack();

	}

	public static void main(String[] args) {
		new PrimeiraTela();
	}

}
