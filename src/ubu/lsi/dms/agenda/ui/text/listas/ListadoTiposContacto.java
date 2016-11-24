package ubu.lsi.dms.agenda.ui.text.listas;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Obtiene un listado con los tipos de contacto almacenados en la BBDD
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class ListadoTiposContacto extends Listado {
	private List<TipoContacto> busqueda;

	public ListadoTiposContacto(FachadaPersistente persistencia) {
		super("Listado de Tipos de Contacto", persistencia);
	}

	@Override
	protected void obtener() throws ReturnException {
		completa();
	}

	private void completa() {
		busqueda = persistencia.getTiposContacto();
		toListado();
	}

	private void toListado() {
		for (TipoContacto e : busqueda) {
			listado.add(getLinea(e));
		}
	}

	private String getLinea(TipoContacto tipocontacto) {
		return tipocontacto.toString();
		/*return Integer.toString(tipocontacto.getIdTipoContacto()) + " "
				+ tipocontacto.getTipoContacto();*/
	}
}
