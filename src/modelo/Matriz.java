package modelo;

public class Matriz {
	private int[][] matriz = new int[10][10];

	public void preencheMatrizComBarcos(int numeroDeCasasDoBarco) {
		int linha = 0;
		int coluna = 0;
		System.out.println(numeroDeCasasDoBarco);
		do {
			linha = (int) Math.round(Math.random() * 9);
			coluna = (int) Math.round(Math.random() * 9);
			System.out.println("Linha " + linha + " Coluna " + coluna);
		} while (matriz[linha][coluna] != 0);

		int contadorDireita = 0, contadorEsquerda = 0, contadorCima = 0, contadorBaixo = 0;
		boolean direitaLivre = false, esquerdaLivre = false, paraCimaLivre = false, paraBaixoLivre = false;

		for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
			if ((0 <= i && i < 10) && matriz[linha][i] == 0) {
				direitaLivre = true;
				contadorDireita++;
			} else if (matriz[linha][i] != 0 || matriz[linha][i] == 1) {
				contadorDireita++;
				direitaLivre = false;
				break;
			}
		}
		if (contadorDireita != numeroDeCasasDoBarco) {
			direitaLivre = false;
		}

		for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
			if (0 <= i && i < 10 && matriz[linha][i] == 0) {
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
			if (0 <= i && i < 10 && matriz[i][coluna] == 0) {
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
			if (0 <= i && i < 10 && matriz[i][coluna] == 0) {
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
					matriz[linha][i] = numeroDeCasasDoBarco;
				}
			}
		} else if (esquerdaLivre) {
			for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1); i--) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[linha][i] = numeroDeCasasDoBarco;
				}
			}
		} else if (paraCimaLivre) {
			for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[i][coluna] = numeroDeCasasDoBarco;
				}
			}
		} else if (paraBaixoLivre) {
			for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
				if ((i < 10 && i >= 0) && (coluna >= 0 && coluna < 10)) {
					matriz[i][coluna] = numeroDeCasasDoBarco;
				}
			}
		} else {
			this.preencheMatrizComBarcos(numeroDeCasasDoBarco);
		}
	}

	public Matriz() {

	}

	public void imprimeMatriz() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%d ", matriz[i][j]);
			}
			System.out.printf("\n");
		}
	}

	/*private void preencheMatriz() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				matriz[i][j] = 0;
			}
		}
	}*/
}