package ubu.lsi.dms.agenda.persistencia;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Esta fachada indica como debe comunicarse la aplicación con la parte de
 * persistencia.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public interface FachadaPersistente {
	/**
	 * Obtiene un contacto facilitando el iD
	 * 
	 * @param idContacto
	 *            Id del contacto a buscar
	 * @return Contacto si se encuentra o null en caso contrario
	 */
	public Contacto getContacto(int idContacto);

	/**
	 * Obtiene una llamada facilitando el iD
	 * 
	 * @param idLlamada
	 *            Id de la llamada a obtener
	 * @return Llamada si se encuentra o null en caso contrario
	 */
	public Llamada getLlamada(int idLlamada);

	/**
	 * Obtiene el tipo contacto facilitado por el iD
	 * 
	 * @param IdTipoContacto
	 *            Id de tipo de contacto a buscar.
	 * @return Tipo de contacto buscado, null en caso de no ser encontrado.
	 */
	public TipoContacto getTipoContacto(int idTipoContacto);

	/**
	 * Crea un nuevo contacto en la base de datos. El id lo rellena
	 * automáticamente cuando se inserta en la BBDD.
	 * 
	 * @param contacto
	 *            Datos del nuevo contacto
	 * @return el id en caso de conseguir la inserción, 0 en caso contrario.
	 */
	public int newContacto(Contacto contacto);

	/**
	 * Crea una nueva llamada en la base de datos. El id lo rellena
	 * automáticamente cuando se inserta en la BBDD.
	 * 
	 * @param llamada
	 *            Datos de la nueva llamada.
	 * @return el id en caso de conseguir la inserción, 0 en caso contrario.
	 */
	public int newLlamada(Llamada llamada);

	/**
	 * Crea un nuevo tipo de contacto en la base de datos. El id lo rellena
	 * automáticamente cuando se inserta en la BBDD.
	 * 
	 * @param tipoContacto
	 *            Datos del nuevo tipo de contacto
	 * @return el id en caso de conseguir la inserción, 0 en caso contrario.
	 */
	public int newTipoContacto(TipoContacto tipoContacto);

	/**
	 * Actualiza el contacto con los datos nuevos
	 * 
	 * @param contacto
	 *            Contacto con los datos a actualizar, debe contener
	 *            obligatoriamente el id.
	 * @return true si se ha conseguido actualizar, false en caso contrario.
	 */
	public boolean updateContacto(Contacto contacto);

	/**
	 * Actualiza la llamada con los datos nuevos
	 * 
	 * @param llamada
	 *            Llamada con los datos a actualizar, debe contener
	 *            obligatoriamente el id.
	 * @return true si se ha conseguido actualizar, false en caso contrario.
	 */
	public boolean updateLlamada(Llamada llamada);

	/**
	 * Actualiza el tipo de contacto con los datos nuevos
	 * 
	 * @param tipoContacto
	 *            Tipo de contacto con los datos a actualizar, debe contener
	 *            obligatoriamente el id.
	 * @return true si se ha conseguido actualizar, false en caso contrario.
	 */
	public boolean updateTipoContacto(TipoContacto tipoContacto);

	/**
	 * Obtiene una lista de contactos que coinciden con los apellidos
	 * facilitados.
	 * 
	 * @param apellidos
	 *            Apellidos a buscar.
	 * @return Lista con los contactos coincidentes, null si no se ha
	 *         encontrado.
	 */
	public List<Contacto> getContactos(String apellidos);

	/**
	 * Obtiene la lista completa de contactos
	 * 
	 * @return Lista con todos los contactos
	 */
	public List<Contacto> getContactos();

	/**
	 * Obtiene una lista de llamadas realizadas por el contacto facilitado.
	 * 
	 * @param idContacto
	 *            Id del contacto del que se quieren obtener las llamadas.
	 * @return Lista con las llamadas coincidentes, null si no se ha encontrado.
	 */
	public List<Llamada> getLlamadas(int idContacto);

	/**
	 * Obtiene una lista de los tipos de contacto que se encuentran en la BBDD.
	 * 
	 * @return Lista con los tipos de contactos coincidentes, null si no se ha
	 *         encontrado.
	 */
	public List<TipoContacto> getTiposContacto();

	/**
	 * Asegura que el sistema de persistencia se cierra de forma correcta.
	 */
	public void close();
}
