package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Notas
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoLlamadaNotas extends Campo {

	private Llamada llamada;

	public CampoLlamadaNotas(Llamada llamada) {
		super("Notas");
		this.llamada = llamada;
	}

	@Override
	protected void tomaValor() {
		valor = llamada.getNotas();
	}

	@Override
	protected void setValor() throws ReturnException {
		llamada.setNotas(teclado.getString());
	}

	public String getValor() {
		return llamada.getNotas();
	}
}
