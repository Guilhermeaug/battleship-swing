package visao.tela1;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import estrutura.Audio;

public class PrimeiraTela extends JFrame {
	JLabel imgLabel = new JLabel();

	public PrimeiraTela() {

		// Som de fundo que toca durante o jogo
		Audio song = new Audio();
		if(Audio.travaAudio == 0){ song.tocarAudio("src/Audio/MissaoImpossivel.wav"); }

		// JLabel com as opcoes
		InformacoesPrimeiraTela informacoes = new InformacoesPrimeiraTela(this);

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
		pack();
	}

	public static void main(String[] args) {
		new PrimeiraTela();
	}

}
