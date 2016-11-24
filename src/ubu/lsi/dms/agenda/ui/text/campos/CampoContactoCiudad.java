package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Ciudad
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoCiudad extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoCiudad(Contacto contacto){
		super("Ciudad");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getCiudad();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setCiudad(teclado.getString());		
	}
	
	public String getValor() {
		return contacto.getCiudad();		
	}

}
