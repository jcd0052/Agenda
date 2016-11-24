package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Apellidos
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoApellidos extends Campo{
	private Contacto contacto;
	
	public CampoContactoApellidos(Contacto contacto){
		super("Apellidos");
		this.contacto = contacto;
	}


	public String getValor() {
		return contacto.getApellidos();		
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setApellidos(teclado.getString());		
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getApellidos();		
	}

}
