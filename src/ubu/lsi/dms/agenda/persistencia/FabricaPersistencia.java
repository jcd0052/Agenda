package ubu.lsi.dms.agenda.persistencia;

/**
 * Interface que nos marca el metodo de acceso común para crear las instancias de persistencia.
 * @author José Ramón Cuevas Diez
 *
 */
public interface FabricaPersistencia {
	public FachadaPersistente crearFachadaPersistente();
}
