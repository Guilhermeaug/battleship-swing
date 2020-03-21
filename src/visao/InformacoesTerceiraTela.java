package visao;//Op��o de reiniciar 

import javax.swing.*;


@SuppressWarnings("serial")
public class InformacoesTerceiraTela extends JPanel{
	
	JButton botaoReiniciar = new JButton();
	JButton botaoFechar = new JButton();
	TerceiraTela tela;

	public InformacoesTerceiraTela(TerceiraTela t){
		tela = t;
		botaoReiniciar.setText("REINICIAR");
		botaoFechar.setText("FECHAR");
		
		botaoReiniciar.addActionListener(e -> reiniciar());
		
		botaoFechar.addActionListener(e -> finalizar());
		
		add(botaoReiniciar);
		add(botaoFechar);
		
	}

	void finalizar() {
		System.exit(0);
	}

	void reiniciar() {
		tela.dispose();
		new PrimeiraTela();
	}

}
