package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ILista;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaTipoContacto;

/**
 * Implementación concreta de las operaciones que se pueden realizar entre la
 * base de datos y la lista de tipos de contacto.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class OperacionesListaTipoContacto extends OperacionesLista {
	
	ListaTipoContacto listaTipoContacto;
	
	public OperacionesListaTipoContacto(){
		this.listaTipoContacto = new ListaTipoContacto();
	}
	
	public OperacionesListaTipoContacto(ListaTipoContacto listaTipoContacto){
		this.listaTipoContacto = listaTipoContacto;
	}
	
	@Override
	public int insertaRegistroBBDD() {
		return persistencia.newTipoContacto(listaTipoContacto.getRegistroSelecionado());
	}

	@Override
	public boolean actualizaRegistroBBDD() {
		return persistencia.updateTipoContacto(listaTipoContacto.getRegistroSelecionado());
	}

	@Override
	public void consultarBBDD(String texto) {
		listaTipoContacto.setLista(persistencia.getTiposContacto());
	}

	@Override
	public ILista getLista() {
		return listaTipoContacto;
	}

}
