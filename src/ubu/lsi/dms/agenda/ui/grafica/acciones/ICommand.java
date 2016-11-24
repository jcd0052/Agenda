package ubu.lsi.dms.agenda.ui.grafica.acciones;

/**
 * Orden de ejecución de los comandos
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public interface ICommand {
	/**
	 * Método utilizado para que un objeto reciba una acción.
	 * @param accion
	 */
	public void realizar(Accion accion);
}
