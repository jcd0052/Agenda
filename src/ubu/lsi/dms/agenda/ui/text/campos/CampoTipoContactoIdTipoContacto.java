package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Este objeto representa el valor contenido del campo idTipoContacto
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoTipoContactoIdTipoContacto extends Campo {
	private TipoContacto tipocontacto;
	
	public CampoTipoContactoIdTipoContacto(TipoContacto tipocontacto){
		super("IdTipoContacto");
		this.tipocontacto = tipocontacto;
	}


	@Override
	protected void tomaValor() {
		super.valor = Integer.toString(tipocontacto.getIdTipoContacto());		
	}

	@Override
	protected void setValor() throws ReturnException {
		System.out.println("");
		// No hay implementación por ser id		
	}
	
	public int getValor() {
		return tipocontacto.getIdTipoContacto();		
	}
}
