package Parte2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EjercicioFichero {

	private static final Logger logger = LoggerFactory.getLogger(EjercicioFichero.class);

	public static void main(String[] args) {

		EjercicioFichero ej = new EjercicioFichero();
		String fichero = "./fichero/FicheroEjercicio2.txt";

		//leer fichero
		ej.leerFichero(fichero);

		//lineas del fichero
		logger.info("===================");
		int lineasTotales = ej.contarLineas(fichero);
		logger.info("El fichero tiene " + lineasTotales + " lineas");

		//contar cunatas veces aparece la palabra
		logger.info("===================");
		String palabra = "Java";
		int palabrasTotales = ej.contarPalabra(fichero, palabra);
		logger.info("Aparece " + palabrasTotales + " veces la palabra " + palabra);

		//guardar en mapa las lineas del fichero
		Map<Integer, String> mapaFichero = ej.crearMapa(fichero);

		//lineas donde aparece la palabra java
		logger.info("===================");
		ej.contienePalabra(mapaFichero, palabra);

		//mostrar clave y caracteres del valor
		logger.info("===================");
		ej.sumaCaracteres(mapaFichero);

	}

	public void leerFichero(String nombre) {
		File archivo = new File(nombre);
		String linea;
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			while ((linea = reader.readLine()) != null) {
				logger.info(linea);
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public int contarLineas(String nombre) {
		File archivo = new File(nombre);
		int i = 0;
		String linea;
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			while ((linea = reader.readLine()) != null) {
				i++;
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return i;
	}

	public int contarPalabra(String nombre, String palabra) {
		File archivo = new File(nombre);
		int i = 0;
		String linea;
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			while ((linea = reader.readLine()) != null) {
				String[] palabras = linea.split(" ");
				for (String plbra : palabras) {
					if (plbra.contains(palabra)) {
						++i;
					}
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return i;
	}

	public Map<Integer, String> crearMapa(String nombre) {
		File archivo = new File(nombre);
		Map<Integer, String> mapaFichero = new HashMap<Integer, String>();
		int i = 1;
		String linea;
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			while ((linea = reader.readLine()) != null) {
				mapaFichero.put(i, linea);
				i++;
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return mapaFichero;
	}

	public void contienePalabra(Map<Integer, String> mapaLineas, String palabra) {
		Set<Integer> lineas = mapaLineas.keySet();
		logger.info("Lineas en las que aparece la palabra: " + palabra);
		for (Integer linea : lineas) {
			if (mapaLineas.get(linea).contains(palabra)) {
				logger.info(String.valueOf(linea));
			}
		}
	}

	public void sumaCaracteres(Map<Integer, String> mapaLineas) {
		Set<Entry<Integer, String>> entries = mapaLineas.entrySet();
		;
		for (Entry<Integer, String> entry : entries) {
			logger.info(String.valueOf(
					"Para la linea " + entry.getKey() + " el número de caracteres es " + entry.getValue().length()));
		}
	}
}
