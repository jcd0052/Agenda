package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista;

import ubu.lsi.dms.agenda.modelo.FabricaEntidades;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Implementación concreta de las operaciones relacionadas con los registros de
 * la lista de tipos de contacto.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class ListaTipoContacto extends Lista<TipoContacto>{

	@Override
	protected void addRegistroLista() {
		lista.add(FabricaEntidades.newTipoContacto());
	}
	
	@Override
	public void setId(int id){
		lista.get(registroSeleccionado).setIdTipoContacto(id);
	}
	
	@Override
	public int getId(){
		return lista.get(registroSeleccionado).getIdTipoContacto();
	}
}
