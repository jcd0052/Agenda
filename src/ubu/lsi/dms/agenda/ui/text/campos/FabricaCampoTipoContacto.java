package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Fábrica para crear los campos correspondientes a la entidad TipoContacto,
 * estos campos se utilizan en los formularios para mostrar el valor actual y
 * recoger el que el usuario introduzca por teclado.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FabricaCampoTipoContacto {

	private TipoContacto tipoContacto;

	public FabricaCampoTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Campo crearCampoTipoContactoIdTipoContacto() {
		return new CampoTipoContactoIdTipoContacto(tipoContacto);
	}

	public Campo crearCampoTipoContactoTipoContacto() {
		return new CampoTipoContactoTipoContacto(tipoContacto);
	}
}
