package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista;

/**
 * Operaciones relacionadas con el mantenimiento de la lista
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public interface ILista {

	/**
	 * Crea una lista vacia y sustituye la actual
	 */
	public void creaListaVacia();

	/**
	 * Añade un nuevo registro a la lista vacia
	 */
	public void creaNuevoRegistro();

	/**
	 * Obtiene el id del registro seleccionado
	 * 
	 * @return el id del registro seleccionado o 0 si es nuevo
	 */
	public int getId();

	/**
	 * Inserta el id devuelto en el registro seleccionado, por una operación de
	 * inserción.
	 * 
	 * @param id
	 */
	public void setId(int Id);

	/**
	 * Devuelve el número del registro seleccionado
	 * 
	 * @return -1 si la lista esta vacia
	 */
	public int getRegistroSeleccionado();
	

	/**
	 * Selecciona el registro siguiente si existe.
	 */
	public void siguiente();

	/**
	 * Selecciona el registro anterior si existe.
	 */
	public void atras();

	/**
	 * Obtiene el número de registros de la lista
	 * 
	 * @return 0 si está vacia
	 */
	public int longitudLista();
}
