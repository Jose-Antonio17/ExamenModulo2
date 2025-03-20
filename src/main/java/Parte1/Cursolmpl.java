package Parte1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cursolmpl implements Curso {
	
	private static final Logger logger = LoggerFactory.getLogger(Curso.class);

	private String nombre;
	private int codigo;
	private int cupoMaximo;
	private int cuposOcupados;
	
	public Cursolmpl(String nombre, int codigo, int cupoMaximo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.cupoMaximo = cupoMaximo;
		this.cuposOcupados = 0; //se crea curso con 0 cupos ocupados
	}

	public int getCuposOcupados() {
		return cuposOcupados;
	}

	public void setCuposOcupados(int cuposOcupados) {
		this.cuposOcupados = cuposOcupados;
	}

	@Override
	public String nombreCurso() {
		return nombre;	
	}

	@Override
	public int codigoCurso() {
		return codigo;		
	}

	@Override
	public void cuposDisponibles() {
		int cuposDisponibles = cupoMaximo - cuposOcupados;
		logger.info("Hay"+cuposDisponibles+"cupos disponibles");		
	}
	
	
	
}
