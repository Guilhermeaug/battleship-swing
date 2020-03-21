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
		int linha;
        int coluna;

        do {
            linha = (int) Math.round(Math.random() * 9);
            coluna = (int) Math.round(Math.random() * 9);
        } while (matriz[linha][coluna].getContemNavio() != 0);

        int contadorDireita = 0, contadorEsquerda = 0, contadorCima = 0, contadorBaixo = 0;
        boolean direitaLivre = false, esquerdaLivre = false, paraCimaLivre = false, paraBaixoLivre = false;

        for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
            //fala se ele pode ser colocado no tabuleiro
            if (matriz[linha][i].getContemNavio() == 0) {
                // Aqui já fazemos a verificação se há outros barcos nas redondezas
                if(linha > 0 && i > 0 && linha < 9 && i < 9){
                    if(matriz[linha+1][i].getContemNavio() == 0 && matriz[linha][i+1].getContemNavio() == 0 && matriz[linha-1][i].getContemNavio() == 0 && matriz[linha][i-1].getContemNavio() == 0){
                        direitaLivre = true;
                        contadorDireita++;
                    }
                }else if(linha == 0){
                    if(i == 0){
                        if(matriz[linha+1][i].getContemNavio() == 0 && matriz[linha][i+1].getContemNavio() == 0){
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    }else if(i == 9){
                        if(matriz[linha+1][i].getContemNavio() == 0 && matriz[linha][i-1].getContemNavio() == 0){
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    }
                }else if(linha == 9){
                    if(i == 0){
                        if(matriz[linha-1][i].getContemNavio() == 0 && matriz[linha][i+1].getContemNavio() == 0){
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    }else if(i == 9){
                        if(matriz[linha-1][i].getContemNavio() == 0 && matriz[linha][i-1].getContemNavio() == 0){
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    }
                }
            }/* Não tem nada para mudar aqui*/else if (matriz[linha][i].getContemNavio() != 0) {
                contadorDireita++;
                direitaLivre = false;
                break;
            }
        }
        if (contadorDireita != numeroDeCasasDoBarco) {
            direitaLivre = false;
        }

        for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
            if (matriz[linha][i].getContemNavio() == 0) {
                // Aqui já fazemos a verificação se há outros barcos nas redondezas
                if(linha > 0 && i > 0 && linha < 9 && i < 9){
                    if(matriz[linha+1][i].getContemNavio() == 0 && matriz[linha][i+1].getContemNavio() == 0 && matriz[linha-1][i].getContemNavio() == 0 && matriz[linha][i-1].getContemNavio() == 0){
                        esquerdaLivre = true;
                        contadorEsquerda++;
                    }
                }else if(linha == 0){
                    if(i == 0){
                        if(matriz[linha+1][i].getContemNavio() == 0 && matriz[linha][i+1].getContemNavio() == 0){
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    }else if(i == 9){
                        if(matriz[linha+1][i].getContemNavio() == 0 && matriz[linha][i-1].getContemNavio() == 0){
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    }
                }else if(linha == 9) {
                    if (i == 0) {
                        if (matriz[linha - 1][i].getContemNavio() == 0 && matriz[linha][i + 1].getContemNavio() == 0) {
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    } else if (i == 9) {
                        if (matriz[linha - 1][i].getContemNavio() == 0 && matriz[linha][i - 1].getContemNavio() == 0) {
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    }
                }
            } /*Aqui não tem nada para mudar*/else {
                contadorEsquerda++;
                esquerdaLivre = false;
                break;
            }
        }
        if (contadorEsquerda != numeroDeCasasDoBarco) {
            esquerdaLivre = false;
        }

        for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
            if (matriz[i][coluna].getContemNavio() == 0) { /*LINHA VIRA I E I VIRA COLUNA, MUDAR COLUNA PRIMEIRO*/
                // Aqui já fazemos a verificação se há outros barcos nas redondezas
                if(i > 0 && coluna > 0 && i < 9 && coluna < 9){
                    if(matriz[i+1][coluna].getContemNavio() == 0 && matriz[i][coluna+1].getContemNavio() == 0 && matriz[i-1][coluna].getContemNavio() == 0 && matriz[i][coluna-1].getContemNavio() == 0){
                        contadorBaixo++;
                        paraBaixoLivre = true;
                    }
                }else if(i == 0){
                    if(coluna == 0){
                        if(matriz[i+1][coluna].getContemNavio() == 0 && matriz[i][coluna+1].getContemNavio() == 0){
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    }else if(coluna == 9){
                        if(matriz[i+1][coluna].getContemNavio() == 0 && matriz[i][coluna-1].getContemNavio() == 0){
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    }
                }else if(i == 9){
                    if(coluna == 0){
                        if(matriz[i-1][coluna].getContemNavio() == 0 && matriz[i][coluna+1].getContemNavio() == 0){
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    }else {
                        if(matriz[i-1][coluna].getContemNavio() == 0 && matriz[i][coluna-1].getContemNavio() == 0){
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    }
                }

            }/*Nada para mudar aqui para baixo*/ else {
                contadorBaixo++;
                paraBaixoLivre = false;
                break;
            }
        }
        if (contadorBaixo != numeroDeCasasDoBarco) {
            paraBaixoLivre = false;
        }

        for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
            if (matriz[i][coluna].getContemNavio() == 0) {
                if(i > 0 && coluna > 0 && i < 9 && coluna < 9){
                    if(matriz[i+1][coluna].getContemNavio() == 0 && matriz[i][coluna+1].getContemNavio() == 0 && matriz[i-1][coluna].getContemNavio() == 0 && matriz[i][coluna-1].getContemNavio() == 0){
                        contadorCima++;
                        paraCimaLivre = true;
                    }
                }else if(i == 0){
                    if(coluna == 0){
                        if(matriz[i+1][coluna].getContemNavio() == 0 && matriz[i][coluna+1].getContemNavio() == 0){
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    }else if(coluna == 9){
                        if(matriz[i+1][coluna].getContemNavio() == 0 && matriz[i][coluna-1].getContemNavio() == 0){
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    }
                }else if(i == 9){
                    if(coluna == 0){
                        if(matriz[i-1][coluna].getContemNavio() == 0 && matriz[i][coluna+1].getContemNavio() == 0){
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    }else {
                        if(matriz[i-1][coluna].getContemNavio() == 0 && matriz[i][coluna-1].getContemNavio() == 0){
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    }
                }
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
                matriz[linha][i].setContemNavio(numeroDeCasasDoBarco);
            }
        } else if (esquerdaLivre) {
            for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1); i--) {
                if (i < 10 && i >= 0 && coluna < 10) {
                    matriz[linha][i].setContemNavio(numeroDeCasasDoBarco);
                }
            }
        } else if (paraCimaLivre) {
            for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
                matriz[i][coluna].setContemNavio(numeroDeCasasDoBarco);
            }
        } else if (paraBaixoLivre) {
            for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
                if (coluna < 10) {
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
					System.out.println("Nao foi destruido");
					return(false);
				}
			}
		}
		System.out.println("Barco destruido");
		return(true);
	}

}