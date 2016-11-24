package ubu.lsi.dms.agenda.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Fábrica que se encarga de generar las entidades de la aplicación
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FabricaEntidades {
	
	/**
	 * Formato de salida de la fecha
	 */
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * Crea un nuevo contacto con todos los campos vacios.
	 * @return contacto vacio
	 */
	public static Contacto newContacto() {
		return new Contacto(0, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Crea un nuevo tipo contacto con todos los campos vacios.
	 * @return tipo contacto vacio
	 */
	public static TipoContacto newTipoContacto() {
		return new TipoContacto(0, "");
	}

	/**
	 * Crea una nueva llamada con todos los campos vacios.
	 * @return llamada vacia
	 */
	public static Llamada newLlamada() {
		return new Llamada(0, null, DATE_FORMAT.format(new Date()), "", "");
	}
}
