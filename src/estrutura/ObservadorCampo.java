package estrutura;

public interface ObservadorCampo { // Interface funcional para os observadores da classe campo
	void notificar(Campo campo, boolean ResultadoDoTiro);
}