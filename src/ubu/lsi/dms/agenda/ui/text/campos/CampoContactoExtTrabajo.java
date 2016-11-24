package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo ExtTrabajo
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoExtTrabajo extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoExtTrabajo(Contacto contacto){
		super("Extensión trabajo");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getExtensionTrabajo();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setExtensionTrabajo(teclado.getString());		
	}
	
	public String getValor() {
		return contacto.getExtensionTrabajo();		
	}
}
