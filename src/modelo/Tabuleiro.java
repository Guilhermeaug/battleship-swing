package modelo;

import java.util.ArrayList;
import java.util.List;

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
	private final List<ObservadorTabuleiroResultado> observadores2 = new ArrayList<>();
	
	
	private void notificarObservadores(boolean statusTiro) {
		for (ObservadorTabuleiro observador : observadores) {
			observador.notificarMisseis(this, misseis, statusTiro);
		}
	}

	public void adicionarObservador(ObservadorTabuleiro obs) {
		observadores.add(obs);
	}

	public void notificarObservadoresResultado(boolean resultado) {
		for(ObservadorTabuleiroResultado observador : observadores2) {
			observador.notificar(this, resultado);
		}
	}
	
	public void adicionarObservador(ObservadorTabuleiroResultado obs) {
		observadores2.add(obs);
	}
	
	// Fim Observadores
	
	public int getMisseis() {
		return misseis;
	}

	public void setMisseis(int misseis) {
		this.misseis = misseis;
	}

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
		int linha = 0;
		int coluna = 0;
		System.out.println(numeroDeCasasDoBarco);
		do {
			linha = (int) Math.round(Math.random() * 9);
			coluna = (int) Math.round(Math.random() * 9);
			System.out.println("Linha " + linha + " Coluna " + coluna);
		} while (matriz[linha][coluna].getContemNavio() != 0);

		int contadorDireita = 0, contadorEsquerda = 0, contadorCima = 0, contadorBaixo = 0;
		boolean direitaLivre = false, esquerdaLivre = false, paraCimaLivre = false, paraBaixoLivre = false;

		for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
			if ((0 <= i && i < 10) && matriz[linha][i].getContemNavio() == 0) {
				direitaLivre = true;
				contadorDireita++;
			} else if (matriz[linha][i].getContemNavio() != 0 || matriz[linha][i].getContemNavio() == 1) {
				contadorDireita++;
				direitaLivre = false;
				break;
			}
		}
		if (contadorDireita != numeroDeCasasDoBarco) {
			direitaLivre = false;
		}

		for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
			if (0 <= i && i < 10 && matriz[linha][i].getContemNavio() == 0) {
				contadorEsquerda++;
				esquerdaLivre = true;
			} else {
				contadorEsquerda++;
				esquerdaLivre = false;
				break;
			}
		}
		if (contadorEsquerda != numeroDeCasasDoBarco) {
			esquerdaLivre = false;
		}

		for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
			if (0 <= i && i < 10 && matriz[i][coluna].getContemNavio() == 0) {
				contadorBaixo++;
				paraBaixoLivre = true;
			} else {
				contadorBaixo++;
				paraBaixoLivre = false;
				break;
			}
		}
		if (contadorBaixo != numeroDeCasasDoBarco) {
			paraBaixoLivre = false;
		}

		for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
			if (0 <= i && i < 10 && matriz[i][coluna].getContemNavio() == 0) {
				contadorCima++;
				paraCimaLivre = true;
			} else {
				contadorCima++;
				paraCimaLivre = false;
				break;
			}
		}
		if (contadorCima != numeroDeCasasDoBarco) {
			paraCimaLivre = false;
		}

		if (direitaLivre) {
			for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[linha][i].setContemNavio(numeroDeCasasDoBarco);
				}
			}
		} else if (esquerdaLivre) {
			for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1); i--) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[linha][i].setContemNavio(numeroDeCasasDoBarco);
				}
			}
		} else if (paraCimaLivre) {
			for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[i][coluna].setContemNavio(numeroDeCasasDoBarco);
				}
			}
		} else if (paraBaixoLivre) {
			for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[i][coluna].setContemNavio(numeroDeCasasDoBarco);
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

		verificaSeFoiDestruido(campo.getContemNavio(), campo);
		notificarObservadores(resultadoDoTiro);

		if (verificaSeGanhou()) {
			notificarObservadoresResultado(true);
		} else if(misseis == 0) {
			notificarObservadoresResultado(false);
		}

	}

	public boolean verificaSeGanhou() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (matriz[i][j].getContemNavio() != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean verificaSeFoiDestruido(int numeroDeCasasDoBarco, Campo campo){
		campo.setContemNavio(0);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(matriz[i][j].getContemNavio() == numeroDeCasasDoBarco){
					System.out.println("Não foi destruído");
					return(false);
				}
			}
		}
		System.out.println("Barco destruido");
		return(true);
	}

}