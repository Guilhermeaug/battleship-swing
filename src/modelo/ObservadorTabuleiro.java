package modelo;

public interface ObservadorTabuleiro {
	public void notificarMisseis(Tabuleiro tabuleiro, int misseis, boolean statusTiro);
}
