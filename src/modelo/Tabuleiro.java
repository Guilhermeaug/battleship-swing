package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Tabuleiro implements ObservadorCampo {
	private int misseis;

	public Campo[][] matriz = new Campo[10][10];

	public Tabuleiro(int misseis) {
		this.misseis = misseis;

		preencherCampos();
		preencheMatrizComBarcos(5);
		preencheMatrizComBarcos(4);
		preencheMatrizComBarcos(3);
		preencheMatrizComBarcos(2);
	}

	// Observadores
	// https://pt.stackoverflow.com/questions/236123/o-que-%C3%A9-e-como-implementar-um-listener-em-java
	private final List<ObservadorTabuleiro> observadores = new ArrayList<>();

	private void notificarObservadores(boolean statusTiro) {
		for (ObservadorTabuleiro observador : observadores) {
			observador.notificarMisseis(this, misseis, statusTiro);
		}
	}

	public void adicionarObservador(ObservadorTabuleiro obs) {
		observadores.add(obs);
	}

	// Fim Observadores

	private void preencherCampos() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Campo campo = new Campo();
				campo.adicionarObservador(this);
				matriz[i][j] = campo;
			}
		}
	}

	public void preencheMatrizComBarcos(int numeroDeCasasDoBarco) {

		int linha = (int) Math.round(Math.random() * 9);
		int coluna = (int) Math.round(Math.random() * 9);

		int contadorDireita = 0, contadorEsquerda = 0, contadorCima = 0, contadorBaixo = 0;
		boolean direitaLivre = false, esquerdaLivre = false, paraCimaLivre = false, paraBaixoLivre = false;

		for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
			if ((0 <= i && i < 10) && matriz[i][coluna].isContemNavio() == false) {
				direitaLivre = true;
				contadorDireita++;
			} else if (matriz[i][coluna].isContemNavio() != false) {
				contadorDireita++;
				direitaLivre = false;
				break;
			}
		}

		if (contadorDireita != numeroDeCasasDoBarco) {
			direitaLivre = false;
		}

		for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
			if (0 <= i && i < 10 && matriz[i][coluna].isContemNavio() == false) {
				contadorEsquerda++;
				esquerdaLivre = true;
			} else if (matriz[i][coluna].isContemNavio() != false) {
				contadorEsquerda++;
				esquerdaLivre = false;
				break;
			}
		}
		if (contadorEsquerda != numeroDeCasasDoBarco) {
			esquerdaLivre = false;
		}

		for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
			if (0 <= i && i < 10 && matriz[linha][i].isContemNavio() == false) {
				contadorBaixo++;
				paraBaixoLivre = true;
			} else if (matriz[linha][i].isContemNavio() != false) {
				contadorBaixo++;
				paraBaixoLivre = false;
				break;
			}
		}
		if (contadorBaixo != numeroDeCasasDoBarco) {
			paraBaixoLivre = false;
		}

		for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
			if (0 <= i && i < 10 && matriz[linha][i].isContemNavio() == false) {
				contadorCima++;
				paraCimaLivre = true;
			} else if (matriz[linha][i].isContemNavio() != false) {
				contadorCima++;
				paraCimaLivre = false;
				break;
			}
		}
		if (contadorCima != numeroDeCasasDoBarco) {
			paraCimaLivre = false;
		}

		if (direitaLivre == true) {
			for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[coluna][i].setContemNavio(true);
				}
			}
		} else if (esquerdaLivre) {
			for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1); i--) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[coluna][i].setContemNavio(true);
				}
			}
		} else if (paraCimaLivre) {
			for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[coluna][i].setContemNavio(true);
				}
			}
		} else if (paraBaixoLivre) {
			for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[coluna][i].setContemNavio(true);
				}
			}
		} else {
			this.preencheMatrizComBarcos(numeroDeCasasDoBarco);
		}
	}

	@Override
	public void notificar(Campo campo, boolean resultadoDoTiro) {
		// campo foi aberto!
		misseis--;
		System.out.println(misseis);

		notificarObservadores(resultadoDoTiro);

		int teste = verificaSeGanhou();

		if (teste == 1) {
			JOptionPane.showMessageDialog(null, "Você ganhou");
		}

	}

	public int verificaSeGanhou() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (matriz[i][j].isContemNavio()) {
					return 0;
				}
			}
		}

		return 1;
	}

}
