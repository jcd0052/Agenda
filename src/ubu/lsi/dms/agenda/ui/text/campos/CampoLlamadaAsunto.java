package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Asunto
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoLlamadaAsunto extends Campo {

	private Llamada Llamada;

	public CampoLlamadaAsunto(Llamada Llamada) {
		super("Asunto");
		this.Llamada = Llamada;
	}

	@Override
	protected void tomaValor() {
		valor = Llamada.getAsunto();
	}

	@Override
	protected void setValor() throws ReturnException {
		Llamada.setAsunto(teclado.getString());
	}

	public String getValor() {
		return Llamada.getAsunto();
	}
}
