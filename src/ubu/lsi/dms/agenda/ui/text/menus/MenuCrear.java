package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.Elemento;

/**
 * Define la estructura de un menu de creación
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class MenuCrear extends Elemento {

	protected String titulo;
	protected FachadaPersistente persistencia;

	public MenuCrear(String titulo, FachadaPersistente persistencia) {
		this.persistencia = persistencia;
		this.titulo = titulo;
	}

	@Override
	public void mostrar() {
		System.out.println("----| " + titulo + " |----");
		crear();
		siguiente();
	}

	protected abstract void crear();

}
