package modelo;

public interface ObservadorCampo {
	public void notificar(Campo campo, boolean ResultadoDoTiro);
}