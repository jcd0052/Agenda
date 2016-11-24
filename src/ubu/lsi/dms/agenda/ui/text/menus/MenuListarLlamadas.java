package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoLlamadas;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos.Busqueda;

/**
 * Genera el menu de listado de llamadas, por contacto
 * pidiendo el contacto a listar
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuListarLlamadas extends MenuListar {

	public MenuListarLlamadas(FachadaPersistente persistencia) {
		super("Listado de Llamadas por contacto", persistencia);
	}

	@Override
	protected void buscar() throws ReturnException {
		ListadoContactos listadoContactos = new ListadoContactos(persistencia,
				Busqueda.COMPLETA);
		listadoContactos.mostrar();
		int idContacto = teclado.getInt("Introduce el idContacto: ");
		System.out.println("");
		ListadoLlamadas listadoLlamadas = new ListadoLlamadas(persistencia,
				persistencia.getContacto(idContacto));
		listadoLlamadas.mostrar();
	}

}
