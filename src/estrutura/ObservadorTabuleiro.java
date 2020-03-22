package estrutura;

public interface ObservadorTabuleiro { // Repassa o resultado dos disparos para a interface gráfica
	void notificarMisseis(Tabuleiro tabuleiro, int misseis, boolean statusTiro, boolean destruido);
}
