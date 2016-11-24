package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.FabricaEntidades;

/**
 * Implementación concreta de las operaciones relacionadas con los registros de
 * la lista de contactos.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class ListaContacto extends Lista<Contacto> {

	@Override
	protected void addRegistroLista() {
		lista.add(FabricaEntidades.newContacto());
	}

	@Override
	public void setId(int id) {
		lista.get(registroSeleccionado).setIdContacto(id);
	}

	@Override
	public int getId() {
		return lista.get(registroSeleccionado).getIdContacto();
	}
}
