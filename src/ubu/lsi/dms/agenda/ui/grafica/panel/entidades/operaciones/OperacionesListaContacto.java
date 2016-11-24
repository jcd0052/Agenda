package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ILista;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaContacto;

/**
 * Implementación concreta de las operaciones que se pueden realizar entre la
 * base de datos y la lista de contactos.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class OperacionesListaContacto extends OperacionesLista {

	ListaContacto listaContacto;

	public OperacionesListaContacto() {
		this.listaContacto = new ListaContacto();
	}

	public OperacionesListaContacto(ListaContacto listaContacto) {
		this.listaContacto = listaContacto;
	}

	@Override
	public int insertaRegistroBBDD() {
		return persistencia.newContacto(listaContacto.getRegistroSelecionado());
	}

	@Override
	public boolean actualizaRegistroBBDD() {
		return persistencia.updateContacto(listaContacto
				.getRegistroSelecionado());
	}

	@Override
	public void consultarBBDD(String texto) {
		listaContacto.setLista(persistencia.getContactos(texto));
	}

	@Override
	public ILista getLista() {
		return listaContacto;
	}

}
