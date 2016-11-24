package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.FormularioContacto;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos;
import ubu.lsi.dms.agenda.ui.text.listas.Formulario.Accion;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos.Busqueda;

/**
 * Genera el menu para actualizar un contacto
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuBuscaActualizaContacto extends MenuListar {

	protected ListadoContactos listaContactos;
	protected Contacto contacto;

	public MenuBuscaActualizaContacto(FachadaPersistente persistencia) {
		super("Opción actualizar Contactos por Apellidos", persistencia);
	}

	@Override
	protected void buscar() throws ReturnException {
		// Pide apellidos a buscar
		this.listaContactos = new ListadoContactos(persistencia,
				Busqueda.APELLIDOS);
		// Pide elegir contacto
		listaContactos.mostrar();
		this.contacto = persistencia.getContacto(teclado
				.getInt("Introduzca el idContacto: "));
		if (contacto != null && contacto.getIdContacto() > 0) {
			actualizar();
		}
	}

	private void actualizar() {
		FormularioContacto actualizarContacto = new FormularioContacto(
				persistencia, contacto, Accion.ACTUALIZAR);
		actualizarContacto.mostrar();
	}

}
