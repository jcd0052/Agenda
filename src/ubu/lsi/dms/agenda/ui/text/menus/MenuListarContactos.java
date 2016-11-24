package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos.Busqueda;

/**
 * Genera el menu de listado de contactos
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuListarContactos extends MenuListar {

	public MenuListarContactos(FachadaPersistente persistencia) {
		super("Listado de Contactos por apellido", persistencia);
	}

	@Override
	protected void buscar() throws ReturnException {
		ListadoContactos listado = new ListadoContactos(persistencia,
				Busqueda.APELLIDOS);
		listado.mostrar();
	}

}
