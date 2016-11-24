package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.Elemento;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Define la estructura de los listados
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class MenuListar extends Elemento {

	protected String titulo;
	protected FachadaPersistente persistencia;

	public MenuListar(String titulo, FachadaPersistente persistencia) {
		this.persistencia = persistencia;
		this.titulo = titulo;
	}

	@Override
	public void mostrar() {
		System.out.println("----| " + titulo + " |----");
		try {
			buscar();
			teclado.pausa();
		} catch (ReturnException e) {
			System.out.println("Operacion cancelada.");
		} finally {
			System.out.println("");
			siguiente();
		}
	}

	protected abstract void buscar() throws ReturnException;

}
