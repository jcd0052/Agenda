package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.modelo.FabricaEntidades;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.listas.FormularioContacto;
import ubu.lsi.dms.agenda.ui.text.listas.Formulario.Accion;

/**
 * Genera el menu para crear un contacto
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuCrearContacto extends MenuCrear {

	public MenuCrearContacto(FachadaPersistente persistencia) {
		super("Opción Crear Contacto", persistencia);
	}

	protected void crear() {
		FormularioContacto crearContacto = new FormularioContacto(persistencia,
				FabricaEntidades.newContacto(), Accion.CREAR);
		crearContacto.mostrar();
	}

}
