package estrutura;

public interface ObservadorTabuleiroAcao { // Repassa o resultado dos disparos para a interface gr�fica
	void notificarMisseis(Tabuleiro tabuleiro, int misseis, boolean statusTiro, boolean destruido);
}
