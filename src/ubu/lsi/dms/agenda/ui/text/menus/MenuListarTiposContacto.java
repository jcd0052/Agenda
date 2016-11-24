package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoTiposContacto;

/**
 * Genera el menu de listado de tipos de contacto
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuListarTiposContacto extends MenuListar {

	public MenuListarTiposContacto(FachadaPersistente persistencia) {
		super("Listado de Tipos de Contacto", persistencia);
	}

	@Override
	protected void buscar() throws ReturnException {
		ListadoTiposContacto listado = new ListadoTiposContacto(persistencia);
		listado.mostrar();
	}

}
