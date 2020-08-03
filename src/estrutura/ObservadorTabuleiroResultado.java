package estrutura;

public interface ObservadorTabuleiroResultado { // Notifica o fim do jogo
	void notificarResultado(Tabuleiro tabuleiro, boolean resultado);
}
