package ubu.lsi.dms.agenda.persistencia;

/**
 * Clase con patrón Singletón que devuelve la única instancia posible de
 * persistencia
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class Persistencia {
	
	public enum Tipo {
		BBDD, BIN
	};
	
	private static String tipo;
	private static FachadaPersistente persistencia;

	/**
	 * Setea el discriminador con el que se creará la fachada persistente.
	 * 
	 * @param tipo
	 */
	public static void setTipo(String tipo) {
		if (persistencia == null) {
			Persistencia.tipo = tipo;
		}
	}

	/**
	 * Devuelve siempre la misma instancia de persistencia.
	 * 
	 * @return
	 */
	public static FachadaPersistente getPersistencia() {
		if (persistencia == null) {
			persistencia = Fachada.crearFachadaPersistente(tipo);
		}
		return persistencia;
	}
	
	/**
	 * Cierre correcto de la persistencia.
	 */
	public static void close(){
		if (persistencia != null){
			persistencia.close();
		}
		System.out.println("Hasta la próxima.");
	}
}
