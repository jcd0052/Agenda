package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo ContactoNombre
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoNombre extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoNombre(Contacto contacto){
		super("Nombre");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getNombre();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setNombre(teclado.getString());		
	}
	
	public String getValor() {
		return contacto.getNombre();		
	}
}
