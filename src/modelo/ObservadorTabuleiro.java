package modelo;

public interface ObservadorTabuleiro {
	void notificarMisseis(Tabuleiro tabuleiro, int misseis, boolean statusTiro);
}
