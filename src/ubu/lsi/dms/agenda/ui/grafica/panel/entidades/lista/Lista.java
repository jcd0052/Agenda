package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista;

import java.util.LinkedList;
import java.util.List;

/**
 * Modifica List para el contexto que necesitamos
 * 
 * @author José Ramón Cuevas Diez
 * 
 * @param <T>
 */
public abstract class Lista<T> implements ILista {

	protected int registroSeleccionado;
	protected List<T> lista;


	public Lista(){
		creaListaVacia();
	}
	
	@Override
	public void creaListaVacia() {
		lista = new LinkedList<T>();
		registroSeleccionado = -1;
	}

	/**
	 * Añade un registro vacio de tipo Entidad a la lista
	 */
	protected abstract void addRegistroLista();

	@Override
	public void creaNuevoRegistro() {
		creaListaVacia();
		addRegistroLista();
		registroSeleccionado = 0;
	}

	@Override
	public int longitudLista() {
		return (lista == null) ? 0 : lista.size();
	}

	@Override
	public int getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	/**
	 * Obtiene el registro seleccionado
	 * 
	 * @return
	 */
	public T getRegistroSelecionado() {
		return lista.get(registroSeleccionado);
	}

	/**
	 * Mantiene referencia a una lista facilitada
	 * 
	 * @param lista
	 */
	public void setLista(List<T> lista) {
		this.lista = lista;
		registroSeleccionado = (longitudLista() == 0) ? -1 : 0;
	}

	@Override
	public void siguiente() {
		if (++registroSeleccionado >= longitudLista()) {
			registroSeleccionado = longitudLista() - 1;
		}
	}

	@Override
	public void atras() {
		if (--registroSeleccionado < 0) {
			registroSeleccionado = (longitudLista() == 0) ? -1 : 0;
		}
	}
}
