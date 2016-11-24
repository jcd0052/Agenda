/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

/**
 * Implementación de la fabrica para base de datos utiliza patron Singleton y
 * devuelve siempre la misma instancia.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FabricaBD implements FabricaPersistencia {
	private static FachadaBD fachadaBD;

	/**
	 * Devuelve la única instancia de Fachada Persistente
	 */
	@Override
	public FachadaPersistente crearFachadaPersistente() {
		if (fachadaBD == null) {
			fachadaBD = new FachadaBD();
		}
		return fachadaBD;
	}

}
