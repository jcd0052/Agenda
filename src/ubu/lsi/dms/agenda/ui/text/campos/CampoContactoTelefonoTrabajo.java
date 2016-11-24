package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo TelefonoTrabajo
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoTelefonoTrabajo extends Campo {

	private Contacto contacto;

	public CampoContactoTelefonoTrabajo(Contacto contacto) {
		super("Teléfono trabajo");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getTelefonoTrabajo();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setTelefonoTrabajo(teclado.getString());
	}

	public String getValor() {
		return contacto.getTelefonoTrabajo();
	}
}
