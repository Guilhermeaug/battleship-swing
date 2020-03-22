package visao.tela2;//Texto la de baixo

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import estrutura.ObservadorTabuleiro;
import estrutura.Tabuleiro;

@SuppressWarnings("serial")
public class InformacoesSegundaTela extends JPanel implements ObservadorTabuleiro {
	JLabel resultadoDoTiro = new JLabel("Resultado: ");
	JLabel bombasDisponiveis = new JLabel("Numero de bombas: ");

	// Tem a qtd de bombas e o status do tiro.
	public InformacoesSegundaTela(Tabuleiro tabuleiro) {
		// setLayout(new GridLayout(1,0));

		tabuleiro.adicionarObservador(this);

		resultadoDoTiro.setFont(new Font("Tahoma", Font.BOLD, 20));

		bombasDisponiveis.setFont(new Font("Tahoma", Font.BOLD, 20));
		bombasDisponiveis.setForeground(new Color(255, 102, 144));

		resultadoDoTiro.setText("CLIQUE!");
		resultadoDoTiro.setForeground(Color.MAGENTA);
		bombasDisponiveis.setText("Numero de bombas: " + tabuleiro.getMisseis() + "   ");

		add(bombasDisponiveis);
		add(resultadoDoTiro);

	}

	@Override
	public void notificarMisseis(Tabuleiro tabuleiro, int misseis, boolean statusTiro, boolean destruido) {
		// A cada tiro, a informacao é atualizada
		if (destruido) {
			resultadoDoTiro.setText("NAVIO DESTRUIDO!");
			resultadoDoTiro.setForeground(Color.YELLOW);
		} else if (statusTiro) {
			resultadoDoTiro.setText("ACERTOU O TIRO!");
			resultadoDoTiro.setForeground(Color.green);
		} else {
			resultadoDoTiro.setText("ERROU O TIRO!");
			resultadoDoTiro.setForeground(Color.red);
		}

		bombasDisponiveis.setText("Numero de bombas: " + misseis + "   ");

	}

}
