package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Cargo
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoCargo extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoCargo(Contacto contacto){
		super("Cargo");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getCargo();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setCargo(teclado.getString());		
	}
	
	public String getValor() {
		return contacto.getCargo();		
	}
}
