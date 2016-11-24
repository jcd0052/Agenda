package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Prov
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoProv extends Campo {

	private Contacto contacto;

	public CampoContactoProv(Contacto contacto) {
		super("Provincia");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getProv();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setProv(teclado.getString());
	}

	public String getValor() {
		return contacto.getProv();
	}
}
