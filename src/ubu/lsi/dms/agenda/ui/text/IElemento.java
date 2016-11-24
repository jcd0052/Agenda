package ubu.lsi.dms.agenda.ui.text;

/**
 * Se denomina elemento a cada parte constituyente del interfaz de texto, por
 * ejemplo campos de texto, listas de selección.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public interface IElemento {

	/**
	 * Setea el siguiente elemento
	 * 
	 * @param elemento
	 */
	public void setSiguiente(IElemento siguiente);

	/**
	 * Pasa el foco al siguiente elemento del menu
	 */
	public void siguiente();

	/**
	 * Muestra en pantalla el elemento
	 */
	public void mostrar();
}
