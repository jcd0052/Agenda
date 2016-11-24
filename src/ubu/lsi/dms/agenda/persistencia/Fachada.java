package ubu.lsi.dms.agenda.persistencia;

/**
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class Fachada {
	/**
	 * Devuelve una instancia de fachada concreta en función del discriminador
	 * 
	 * @param discriminador
	 * @return
	 */
	public static FachadaPersistente crearFachadaPersistente(
			String discriminador) {
		if ("BBDD".equals(discriminador)) {
			return new FabricaBD().crearFachadaPersistente();
		} else {
			return new FabricaBin().crearFachadaPersistente();
		}
	}
}
