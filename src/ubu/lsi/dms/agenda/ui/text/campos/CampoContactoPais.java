package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Pais
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoPais extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoPais(Contacto contacto){
		super("Pais");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getPais();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setPais(teclado.getString());		
	}

	public String getValor() {
		return contacto.getPais();		
	}
}
