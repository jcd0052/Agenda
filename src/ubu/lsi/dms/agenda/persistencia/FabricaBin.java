/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Fábrica de creación de la persistencia por fichero.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FabricaBin implements FabricaPersistencia {
	private static FachadaBin fachadaBin;
	private static File fagenda;

	/**
	 * Utiliza el patrón Singleton, devuelve siempre una instancia de
	 * persistencia
	 */
	@Override
	public FachadaPersistente crearFachadaPersistente() {
		if (fachadaBin == null) {
			recuperaAgenda();
			if (fachadaBin == null) {
				fachadaBin = new FachadaBin(fagenda);
			}
		}
		return fachadaBin;
	}

	/**
	 * Comprueba si existe el fichero de persistencia, si existe lo convierte en
	 * el objeto FachadaBin, que contiene a su vez todos los objetos de datos.
	 */
	private static void recuperaAgenda() {
		fagenda = new File("./data/agenda.dat");
		try {
			if (fagenda.exists()) {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(fagenda));
				fachadaBin = (FachadaBin) in.readObject();
				in.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
