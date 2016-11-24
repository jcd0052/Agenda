package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo CorreoElectronico
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoNomCorreoElectronico extends Campo {
	
	private Contacto contacto;
	
	public CampoContactoNomCorreoElectronico(Contacto contacto){
		super("Nombre correo electrónico");
		this.contacto = contacto;
	}

	@Override
	protected void tomaValor() {
		valor = contacto.getNomCorreoElectronico();
	}

	@Override
	protected void setValor() throws ReturnException {
		contacto.setNomCorreoElectronico(teclado.getString());		
	}

	public String getValor() {
		return contacto.getNomCorreoElectronico();		
	}
}
