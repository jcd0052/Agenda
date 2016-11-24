package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista;

import ubu.lsi.dms.agenda.modelo.FabricaEntidades;
import ubu.lsi.dms.agenda.modelo.Llamada;

/**
 * Implementación concreta de las operaciones relacionadas con los registros de
 * la lista de llamadas.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class ListaLlamada extends Lista<Llamada> {

	@Override
	protected void addRegistroLista() {
		lista.add(FabricaEntidades.newLlamada());
	}
	
	@Override
	public void setId(int id){
		lista.get(registroSeleccionado).setIdLlamada(id);
	}
	
	@Override
	public int getId(){
		return lista.get(registroSeleccionado).getIdLlamada();
	}
}
