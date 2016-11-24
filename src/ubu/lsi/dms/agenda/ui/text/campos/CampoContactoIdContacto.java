package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo idContacto
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoIdContacto extends Campo {
	private Contacto contacto;
	
	public CampoContactoIdContacto(Contacto contacto){
		super("IdContacto");
		this.contacto = contacto;
	}


	@Override
	protected void tomaValor() {
		super.valor = Integer.toString(contacto.getIdContacto());		
	}

	@Override
	protected void setValor() throws ReturnException {
		System.out.println("");
		// No hay implementación por ser id		
	}
	
	public int getValor() {
		return contacto.getIdContacto();		
	}
}
