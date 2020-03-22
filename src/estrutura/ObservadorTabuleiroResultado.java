package estrutura;

public interface ObservadorTabuleiroResultado { // Notifica o fim do jogo
	void notificar(Tabuleiro tabuleiro, boolean resultado);
}
