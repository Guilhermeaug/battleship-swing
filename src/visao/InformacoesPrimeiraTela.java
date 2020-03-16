package visao;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformacoesPrimeiraTela extends JPanel implements MouseListener {

	JLabel dificuldadeDoJogo = new JLabel();

	// https://www.javaprogressivo.net/2014/04/Tutorial-JCheckBox-Java-Como-Usar-Botoes-Checagem-CheckBox.html
	ButtonGroup botoes = new ButtonGroup();
	JRadioButton facil;
	JRadioButton medio;
	JRadioButton dificil;

	JButton botaoIniciar = new JButton();

	// Observadores
	// https://pt.stackoverflow.com/questions/236123/o-que-%C3%A9-e-como-implementar-um-listener-em-java
	private final List<ObservadorTela1> observadores = new ArrayList<>();

		private void notificarObservadores() {
			for (ObservadorTela1 observador : observadores) {
				observador.notificar(this);
			}
		}

	public void adicionarObservador(ObservadorTela1 obs) {
		observadores.add(obs);
	}

	// Fim Observadores

	public InformacoesPrimeiraTela() {
		setLayout(new BorderLayout(10, 10));

		JPanel titulo = new JPanel();
		titulo.setLayout(new BorderLayout());
		titulo.add(dificuldadeDoJogo, BorderLayout.NORTH);

		JPanel opcoes = new JPanel();
		facil = new JRadioButton("F�cil", false);
		medio = new JRadioButton("M�dio", false);
		dificil = new JRadioButton("Dif�cil", false);
		botoes.add(facil);
		botoes.add(medio);
		botoes.add(dificil);
		opcoes.add(facil);
		opcoes.add(medio);
		opcoes.add(dificil);

		dificuldadeDoJogo.setText("Dificuldade do jogo:	");
		dificuldadeDoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		botaoIniciar.setText("Iniciar jogo");
		botaoIniciar.addMouseListener(this);

		add(titulo, BorderLayout.NORTH);
		add(opcoes, BorderLayout.CENTER);
		add(botaoIniciar, BorderLayout.SOUTH);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (facil.isSelected()) {
			new BatalhaNaval(80);
			notificarObservadores();
		}else if(medio.isSelected()) {
			new BatalhaNaval(50);
			notificarObservadores();
		}else if(dificil.isSelected()) {
			new BatalhaNaval(25);
			notificarObservadores();
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
