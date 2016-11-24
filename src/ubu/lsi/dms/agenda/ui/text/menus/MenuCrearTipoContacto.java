package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.modelo.FabricaEntidades;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.listas.FormularioTipoContacto;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoTiposContacto;
import ubu.lsi.dms.agenda.ui.text.listas.Formulario.Accion;

/**
 * Genera el menu para crear un tipocontacto
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuCrearTipoContacto extends MenuCrear {

	protected ListadoTiposContacto listaTiposContacto;
	protected TipoContacto tipoContacto;

	public MenuCrearTipoContacto(FachadaPersistente persistencia) {
		super("Opción crear Tipo de Contacto", persistencia);
	}

	@Override
	protected void crear() {
		FormularioTipoContacto crearTipoContacto = new FormularioTipoContacto(
				persistencia, FabricaEntidades.newTipoContacto(), Accion.CREAR);
		crearTipoContacto.mostrar();
	}

}
