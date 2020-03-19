package visao;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Audio;

@SuppressWarnings("serial")
public class PrimeiraTela extends JFrame implements ObservadorTela1 {
	JLabel imgLabel = new JLabel();

	public PrimeiraTela() {
		
		Audio song = new Audio();
		song.tocarAudio("src/Audio/MissaoImpossivel.wav");
		
		InformacoesPrimeiraTela informacoes = new InformacoesPrimeiraTela();
		informacoes.adicionarObservador(this);

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
		
		Color minhaCor = new Color(255, 255, 255);
		setBackground(minhaCor);
		
		pack();
		
	}

	@Override
	public void notificar(InformacoesPrimeiraTela tela1) {
		// A dificuldade foi selecionada! Hora de seguir adiante.
		dispose();

	}
	
	public static void main(String[] args) {
		new PrimeiraTela();
	}

}
