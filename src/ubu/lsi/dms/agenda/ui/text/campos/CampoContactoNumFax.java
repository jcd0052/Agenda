package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo NumFax
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoNumFax extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoNumFax(Contacto contacto){
		super("Número fax");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getNumFax();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setNumFax(teclado.getString());		
	}

	public String getValor() {
		return contacto.getNumFax();		
	}
}
