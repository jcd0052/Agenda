package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo TipoContacto
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoTipoContactoTipoContacto extends Campo {
	
	private TipoContacto tipocontato;
	
	public CampoTipoContactoTipoContacto(TipoContacto tipocontato){
		super("Nombre");
		this.tipocontato = tipocontato;
	}

	@Override
	protected void tomaValor() {
		valor = tipocontato.getTipoContacto();
	}

	@Override
	protected void setValor() throws ReturnException {
		tipocontato.setTipoContacto(teclado.getString());		
	}
	
	public String getValor() {
		return tipocontato.getTipoContacto();		
	}
}
