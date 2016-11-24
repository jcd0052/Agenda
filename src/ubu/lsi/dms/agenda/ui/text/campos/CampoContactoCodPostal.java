package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo CodPostal
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoCodPostal extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoCodPostal(Contacto contacto){
		super("Código postal");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getCodPostal();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setCodPostal(teclado.getString());		
	}
	
	public String getValor() {
		return contacto.getCodPostal();		
	}

}
