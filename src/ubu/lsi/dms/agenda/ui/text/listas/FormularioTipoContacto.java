package ubu.lsi.dms.agenda.ui.text.listas;

import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.campos.FabricaCampoTipoContacto;

/**
 * Genera un formulario para ser rellenado con los campos correspondientes a la
 * entidad TipoContacto, facilitando el TipoContacto para ser actualizado o uno
 * vacio para ser creado.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FormularioTipoContacto extends Formulario {
	protected FachadaPersistente persistencia;
	protected TipoContacto tipoContacto;

	public FormularioTipoContacto(FachadaPersistente persistencia,
			TipoContacto tipoContacto, Accion accion) {
		super(new FabricaCampoTipoContacto(tipoContacto)
				.crearCampoTipoContactoIdTipoContacto(),
				"Formulario TipoContacto", accion);
		FabricaCampoTipoContacto ftipoContacto = new FabricaCampoTipoContacto(
				tipoContacto);
		this.persistencia = persistencia;
		this.tipoContacto = tipoContacto;
		addCampo(ftipoContacto.crearCampoTipoContactoTipoContacto());
	}

	@Override
	protected boolean crear() {
		return (persistencia.newTipoContacto(tipoContacto) > 0) ? true : false;
	}

	@Override
	protected boolean actualizar() {
		return persistencia.updateTipoContacto(tipoContacto);
	}
}
