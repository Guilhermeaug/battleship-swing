package modelo;

public interface ObservadorCampo {
	void notificar(Campo campo, boolean ResultadoDoTiro);
}