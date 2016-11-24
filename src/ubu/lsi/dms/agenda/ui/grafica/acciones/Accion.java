package ubu.lsi.dms.agenda.ui.grafica.acciones;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGui;

/**
 * Permite a un objeto recibir acciones para ser realizadas, este interface
 * encapsula dicha acción.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public interface Accion {
	/**
	 * Método que ejecuta el comando.
	 * 
	 * @param entidad
	 *            objeto sobre el que hay que efectuar la acción.
	 */
	public void ejecutar(EntidadGui entidad);
}
