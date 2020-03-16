package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class InformacoesTerceiraTela extends JPanel{
	
	JButton botaoReiniciar = new JButton();
	JButton botaoFechar = new JButton();
	TerceiraTela tela;

	public InformacoesTerceiraTela(TerceiraTela t){
		tela = t;
		botaoReiniciar.setText("REINICIAR");
		botaoFechar.setText("FECHAR");
		
		botaoReiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciar(e);
			}
		});
		
		botaoFechar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}
		});
		
		add(botaoReiniciar);
		add(botaoFechar);
		
	}

	void finalizar() {
		System.exit(0);
	}

	void reiniciar(ActionEvent e) {
		tela.dispose();
		new PrimeiraTela();
	}

}
