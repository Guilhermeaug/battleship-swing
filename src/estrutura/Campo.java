package estrutura;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private boolean aberto = false;
	private int contemNavio = 0;
	Audio som = new Audio(); // Classe Audio para tocar som
	
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public int getContemNavio() {
		return contemNavio;
	}

	public void setContemNavio(int contemNavio) {
		this.contemNavio = contemNavio;
	}

	// Observadores
	// https://pt.stackoverflow.com/questions/236123/o-que-%C3%A9-e-como-implementar-um-listener-em-java
	private final List<ObservadorCampo> observadorCampos = new ArrayList<>();

	private void notificarObservadores(boolean resultado) {
		for (ObservadorCampo observador : observadorCampos) {
			observador.notificarTabuleiro(this, resultado);
		}
	}

	public void adicionarObservador(ObservadorCampo obs) {
		observadorCampos.add(obs);
	}
	// Fim Observadores

	// Fun��o acionada apos o clique do usuario que retorna o acerto ou erro
	public boolean abrirCampo() {
		if (!aberto) { // Se o campo n�o estiver aberto
			setAberto(true); // Agora ele foi aberto!

			if (contemNavio != 0) { // Se houver um navio neste ponto
				String filepath = "src/Audio/bombaBarco.wav"; // Caminho do som de acerto
				som.tocarAudio(filepath); // Toca o som de acerto
				notificarObservadores(true); // Notifica o tabuleiro que o tiro foi preciso!
				contemNavio = 0; // Agora n�o h� mais um navio aqui
				return true; // Retorna para o JButton que o disparo acertou um navio
			} else { // Se n�o houver um navio
				String filepath = "src/Audio/bombaAgua.wav"; // Caminho do som de erro
				som.tocarAudio(filepath); // Toca o som de erro
				notificarObservadores(false); // Notifica o tabuleiro que a bomba caiu na �gua
			}
		}

		return false; // O campo n�o tinha navio
	}

}
