package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo NomCompania
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoNomCompania extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoNomCompania(Contacto contacto){
		super("Nombre Compañia");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getNombreCompania();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setNombreCompania(teclado.getString());		
	}
	
	public String getValor() {
		return contacto.getNombreCompania();		
	}
}
