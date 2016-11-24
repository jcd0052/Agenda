package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo Estimado
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoEstimado extends Campo{
private Contacto contacto;
	
	public CampoContactoEstimado(Contacto contacto){
		super("Estimado");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getEstimado();
		
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setEstimado(teclado.getString());		
	}

	public String getValor() {
		return contacto.getEstimado();		
	}
}
