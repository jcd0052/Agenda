package ubu.lsi.dms.agenda.ui.text.listas;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Obtiene un listado con las llamadas almacenados en la BBDD con el contacto
 * facilitado.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class ListadoLlamadas extends Listado {
	private List<Llamada> busqueda;
	private Contacto contacto;

	public ListadoLlamadas(FachadaPersistente persistencia, Contacto contacto) {
		super("Listado de Llamadas", persistencia);
		this.contacto = contacto;
	}

	@Override
	protected void obtener() throws ReturnException {
		busqueda = persistencia.getLlamadas(contacto.getIdContacto());
		toListado();
	}

	private void toListado() {
		for (Llamada e : busqueda) {
			listado.add(getLinea(e));
		}
	}

	private String getLinea(Llamada llamada) {
		return llamada.toString();
		/*
		 * return Integer.toString(llamada.getIdLlamada()) + " " +
		 * llamada.getContacto().getNombre() + " " + llamada.getAsunto() + " " +
		 * llamada.getFechaLlamada();
		 */
	}
}
