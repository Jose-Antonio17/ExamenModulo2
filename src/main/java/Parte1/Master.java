package Parte1;

public class Master extends Cursolmpl {

	private boolean oficial;

	public Master(String nombre, int codigo, int cupoMaximo, boolean oficial) {
		super(nombre, codigo, cupoMaximo);
		this.oficial = oficial;
	}

	public boolean isOficial() {
		return oficial;
	}

	public void setOficial(boolean oficial) {
		this.oficial = oficial;
	}
	
}
