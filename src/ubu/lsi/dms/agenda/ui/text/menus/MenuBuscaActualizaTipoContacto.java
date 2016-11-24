package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.FormularioTipoContacto;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoTiposContacto;
import ubu.lsi.dms.agenda.ui.text.listas.Formulario.Accion;

/**
 * Genera el menu para actualizar un tipo de contacto
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuBuscaActualizaTipoContacto extends MenuListar {

	protected ListadoTiposContacto listaTiposContacto;
	protected TipoContacto tipoContacto;

	public MenuBuscaActualizaTipoContacto(FachadaPersistente persistencia) {
		super("Opcion actualizar tipos de Contacto", persistencia);
	}

	@Override
	protected void buscar() throws ReturnException {
		// Pide elegir tipo de contacto
		this.listaTiposContacto = new ListadoTiposContacto(persistencia);
		listaTiposContacto.mostrar();
		int idTipoContacto = teclado.getInt("Introduzca el idTipoContacto: ");
		this.tipoContacto = persistencia.getTipoContacto(idTipoContacto);
		if (tipoContacto != null && tipoContacto.getIdTipoContacto() > 0) {
			actualizar();
		}
	}

	private void actualizar() {
		FormularioTipoContacto actualizarTipoContacto = new FormularioTipoContacto(
				persistencia, tipoContacto, Accion.ACTUALIZAR);
		actualizarTipoContacto.mostrar();
	}

}
