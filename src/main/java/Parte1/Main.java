package Parte1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main (String [] args) {
		
		Main m = new Main();
		
		List<Master> listaMaster = m.crearMaster();
		
		//eliminar master por codigo
		int codigo = 101;
		m.eliminarMaster(listaMaster, codigo);
		
		//mostrar master oficiales
		m.mostrarNombre(listaMaster);
		
	}
	
	public List<Master> crearMaster() {
		//crear 3 master nuevos
		Master master1 = new Master("Nombre1", 101, 12, true);
		Master master2 = new Master("Nombre2", 102, 15, false);
		Master master3 = new Master("Nombre3", 103, 10, true);
		
		//guardar en un lista
		List<Master> listaMaster = new CopyOnWriteArrayList<Master>();
		listaMaster.addAll(Arrays.asList(master1, master2, master3));
		return listaMaster;
	}

	public void eliminarMaster(List<Master> lista , int codigo) {	
		for (int i = 0;i<lista.size();i++) {
			if(lista.get(i).codigoCurso() == codigo) {
				 lista.remove(i--);
			}
		}
	}
	
	public void mostrarNombre(List<Master> lista) {
		for (Master master : lista) {
			if(master.isOficial()) {
			logger.info(master.nombreCurso());
			}
		}
	}
}
