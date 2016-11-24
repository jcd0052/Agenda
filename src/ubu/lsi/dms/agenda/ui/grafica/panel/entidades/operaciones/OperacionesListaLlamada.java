package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.Utilidades;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ILista;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaLlamada;

/**
 * Implementación concreta de las operaciones que se pueden realizar entre la
 * base de datos y la lista de llamadas.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class OperacionesListaLlamada extends OperacionesLista {
	
	ListaLlamada listaLlamada;
	
	public OperacionesListaLlamada(){
		this.listaLlamada = new ListaLlamada();
	}
	
	public OperacionesListaLlamada(ListaLlamada listaLlamada){
		this.listaLlamada = listaLlamada;
	}
	
	@Override
	public int insertaRegistroBBDD() {
		return persistencia.newLlamada(listaLlamada.getRegistroSelecionado());
	}

	@Override
	public boolean actualizaRegistroBBDD() {
		return persistencia.updateLlamada(listaLlamada.getRegistroSelecionado());
	}

	@Override
	public void consultarBBDD(String texto) {
		listaLlamada.setLista(persistencia.getLlamadas(Utilidades.getValor(texto)));
	}

	@Override
	public ILista getLista() {
		return listaLlamada;
	}

}
