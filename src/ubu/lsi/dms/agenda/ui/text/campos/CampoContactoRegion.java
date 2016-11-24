package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Region
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoRegion extends Campo {

	private Contacto contacto;

	public CampoContactoRegion(Contacto contacto) {
		super("Región");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getRegion();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setRegion(teclado.getString());
	}

	public String getValor() {
		return contacto.getRegion();
	}
}
