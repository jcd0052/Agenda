package ubu.lsi.dms.agenda.ui.text.campos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Fecha Llamada
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoLlamadaFechaLlamada extends Campo {

	/**
	 * Formato de salida de la fecha
	 */
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private Llamada llamada;

	public CampoLlamadaFechaLlamada(Llamada llamada) {
		super("Fecha");
		this.llamada = llamada;
	}

	@Override
	protected void tomaValor() {
		valor = llamada.getFechaLlamada();
		if (valor == "") {
			valor = DATE_FORMAT.format(new Date());
			llamada.setFechaLlamada(valor);
		}
	}

	@Override
	protected void setValor() throws ReturnException {
		llamada.setFechaLlamada(teclado.getString());
	}

	public String getValor() {
		return llamada.getFechaLlamada();
	}
}
