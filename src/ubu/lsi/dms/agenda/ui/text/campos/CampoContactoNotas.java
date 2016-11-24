package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Notas
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoNotas extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoNotas(Contacto contacto){
		super("Notas");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getNotas();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setNotas(teclado.getString());		
	}
	
	public String getValor() {
		return contacto.getNotas();		
	}
}
