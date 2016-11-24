package ubu.lsi.dms.agenda.ui.grafica.acciones;

/**
 * Comandos de acciones que se pueden realizar con las EntidadesGui
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public interface IComandos {

	/**
	 * Crea un nuevo registro vacio para rellenar
	 */
	public void nuevo();

	/**
	 * Inserta un registro nuevo en la BBDD
	 */
	public void insertar();

	/**
	 * Permite modificar un registro de la BBDD
	 */
	public void editar();

	/**
	 * Guarda los cambios efectuados en el registro
	 */
	public void actualizar();

	/**
	 * Cancela las operaciones de registro nuevo y edición
	 */
	public void cancelar();

	/**
	 * Realiza una consulta en la base de datos
	 * 
	 * @param texto
	 */
	public void consultar(String texto);

	/**
	 * Pasa al siguiente registro si lo hay
	 */
	public void siguiente();

	/**
	 * Vuelve al registro anterior si lo hay
	 */
	public void atras();
}
