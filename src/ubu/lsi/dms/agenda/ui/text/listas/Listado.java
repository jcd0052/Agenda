package ubu.lsi.dms.agenda.ui.text.listas;

import java.util.LinkedList;
import java.util.List;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.Elemento;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Define la estructura de los listados
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class Listado extends Elemento {
	protected List<String> listado;
	protected String titulo;
	protected FachadaPersistente persistencia;

	public Listado(String titulo, FachadaPersistente persistencia) {
		this.listado = new LinkedList<String>();
		this.titulo = titulo;
		this.persistencia = persistencia;
	}

	@Override
	public void mostrar() {
		try {
			obtener();
			System.out.println(titulo);
			System.out.println("-------------------------------");
			if (listado.isEmpty()) {
				System.out.println("----NO HAY NADA QUE MOSTRAR----");
			}
			for (String linea : listado) {
				System.out.println(linea);
			}
		} catch (ReturnException e) {
			System.out.println("Listado cancelado por el usuario.\n");
		}
	}

	protected abstract void obtener() throws ReturnException;

}
