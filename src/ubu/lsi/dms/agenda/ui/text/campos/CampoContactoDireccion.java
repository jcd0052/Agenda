package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Direccion
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoDireccion extends Campo {
	
private Contacto contacto;
	
	public CampoContactoDireccion(Contacto contacto){
		super("Direccion");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getDireccion();
		
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setDireccion(teclado.getString());		
	}

	public String getValor() {
		return contacto.getDireccion();		
	}
}
