package modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private boolean aberto = false;
	private int contemNavio = 0;
	Audio som = new Audio();

	// Observadores
	// https://pt.stackoverflow.com/questions/236123/o-que-%C3%A9-e-como-implementar-um-listener-em-java
	private final List<ObservadorCampo> observadores = new ArrayList<>();

	private void notificarObservadores(boolean resultado) {
		for (ObservadorCampo observador : observadores) {
			observador.notificar(this, resultado);
		}
	}

	public void adicionarObservador(ObservadorCampo obs) {
		observadores.add(obs);
	}

	// Fim Observadores

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public int getContemNavio() {
		return contemNavio;
	}

	public void setContemNavio(int contemNavio) {
		this.contemNavio = contemNavio;
	}

	public int abrirCampo() {
		if (!aberto) {
			setAberto(true);

			if (contemNavio != 0 ) {
				String filepath = "src/Audio/bombaBarco.wav";
				som.tocarAudio(filepath);
				System.out.println("Acertou um navio!");
				notificarObservadores(true);
				contemNavio = 0;
				return 1;
			} else {
				String filepath = "src/Audio/bombaAgua.wav";
				som.tocarAudio(filepath);
				System.out.println("Errou o tiro!");
			}

			notificarObservadores(false);
		} else {
			return 2;
		}

		return 0;
	}

}
