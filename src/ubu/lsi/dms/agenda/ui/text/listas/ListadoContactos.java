package ubu.lsi.dms.agenda.ui.text.listas;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Obtiene un listado con los contactos almacenados en la BBDD, bien por nombre
 * o completo.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class ListadoContactos extends Listado {
	private List<Contacto> busqueda;
	private Busqueda tipo;

	public ListadoContactos(FachadaPersistente persistencia, Busqueda tipo) {
		super("Listado de Contactos", persistencia);
		this.tipo = tipo;
	}

	@Override
	protected void obtener() throws ReturnException {
		if (tipo == Busqueda.APELLIDOS) {
			apellidos();
		} else {
			completa();
		}
	}

	public enum Busqueda {
		COMPLETA, APELLIDOS
	}

	private void completa() {
		busqueda = persistencia.getContactos();
		toListado();
	}

	private void apellidos() throws ReturnException {
		System.out.print("Introduce apellido a buscar: ");
		busqueda = persistencia.getContactos(teclado.getString());
		System.out.println("");
		toListado();
	}

	private void toListado() {
		for (Contacto e : busqueda) {
			listado.add(getLinea(e));
		}
	}

	private String getLinea(Contacto contacto) {
		return contacto.toString();
		/*
		 * return Integer.toString(contacto.getIdContacto()) + " " +
		 * contacto.getNombre() + " " + contacto.getApellidos() + " " +
		 * contacto.getTelefonoMovil();
		 */
	}
}
