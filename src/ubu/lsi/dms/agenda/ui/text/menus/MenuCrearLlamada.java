package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.modelo.FabricaEntidades;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.listas.FormularioLlamada;
import ubu.lsi.dms.agenda.ui.text.listas.Formulario.Accion;

/**
 * Genera el menu para crear una llamada
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuCrearLlamada extends MenuCrear {

	public MenuCrearLlamada(FachadaPersistente persistencia) {
		super("Opción crear llamada", persistencia);
	}

	@Override
	protected void crear() {
		FormularioLlamada crearLlamada = new FormularioLlamada(persistencia,
				FabricaEntidades.newLlamada(), Accion.CREAR);
		crearLlamada.mostrar();
	}

}
