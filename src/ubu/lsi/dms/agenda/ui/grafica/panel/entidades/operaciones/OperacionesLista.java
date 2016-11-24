package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.persistencia.Persistencia;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ILista;

/**
 * Operaciones que se pueden realizar con la lista de registros relacionadas con
 * la BBDD.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class OperacionesLista {

	protected FachadaPersistente persistencia;

	protected OperacionesLista() {
		persistencia = Persistencia.getPersistencia();
	}

	/**
	 * Inserta el registro seleccionado de la lista en la base de datos.
	 * 
	 * @return 0 en caso de no haber pasado alguna restricción, el id
	 *         correspondiente que le ha asignado la BBDD.
	 */
	public abstract int insertaRegistroBBDD();

	/**
	 * Actualiza en la base de datos con el registro seleccionado de la lista,
	 * la tupla cuyo id sea el mismo.
	 * 
	 * @return true si se ha realizado con éxito.
	 */
	public abstract boolean actualizaRegistroBBDD();

	/**
	 * Consulta en la base de datos las tuplas que coinciden con el texto
	 * buscado, si se necesita. El resultado lo introduce en la lista.
	 */
	public abstract void consultarBBDD(String texto);

	/**
	 * Obtiene toda la lista
	 * 
	 * @return
	 */
	public abstract ILista getLista();
}
