package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo TelMovil
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoTelMovil extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoTelMovil(Contacto contacto){
		super("Teléfono movil");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getTelefonoMovil();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setTelefonoMovil(teclado.getString());		
	}

	public String getValor() {
		return contacto.getTelefonoMovil();		
	}
}
