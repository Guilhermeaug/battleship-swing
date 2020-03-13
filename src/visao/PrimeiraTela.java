package visao;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PrimeiraTela extends JFrame implements ObservadorTela1 {
	JLabel imgLabel = new JLabel();

	public PrimeiraTela() {

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
