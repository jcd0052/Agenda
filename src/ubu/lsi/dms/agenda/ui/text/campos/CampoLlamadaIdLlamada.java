package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo IdLLamada
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoLlamadaIdLlamada extends Campo {
	private Llamada llamada;

	public CampoLlamadaIdLlamada(Llamada llamada) {
		super("IdLlamada");
		this.llamada = llamada;
	}

	@Override
	protected void tomaValor() {
		super.valor = Integer.toString(llamada.getIdLlamada());
	}

	@Override
	protected void setValor() throws ReturnException {
		System.out.println("");
		// No hay implementación por ser id
	}

	public int getValor() {
		return llamada.getIdLlamada();
	}
}
