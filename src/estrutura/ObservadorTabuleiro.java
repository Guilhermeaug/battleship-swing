package estrutura;

public interface ObservadorTabuleiro { // Repassa o resultado dos disparos para a interface gr�fica
	void notificarMisseis(Tabuleiro tabuleiro, int misseis, boolean statusTiro, boolean destruido);
}
