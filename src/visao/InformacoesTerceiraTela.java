package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InformacoesTerceiraTela extends JPanel{
	
	JButton botaoReiniciar = new JButton();
	JButton botaoFechar = new JButton();
	
	public InformacoesTerceiraTela() {
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
		
	}

	void reiniciar(ActionEvent e) {
		
	}

}
