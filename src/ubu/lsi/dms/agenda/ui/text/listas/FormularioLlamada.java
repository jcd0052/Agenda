package ubu.lsi.dms.agenda.ui.text.listas;

import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.campos.FabricaCampoLlamada;

/**
 * Genera un formulario para ser rellenado con los campos correspondientes a la
 * entidad Llamada, facilitando la Llamada para ser actualizada o una
 * vacia para ser creada.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FormularioLlamada extends Formulario {
	protected FachadaPersistente persistencia;
	protected Llamada llamada;

	public FormularioLlamada(FachadaPersistente persistencia,
			Llamada llamada, Accion accion) {
		super(new FabricaCampoLlamada(persistencia, llamada)
				.crearCampoLlamadaIdLlamada(), "Formulario Llamada", accion);
		FabricaCampoLlamada fllamada = new FabricaCampoLlamada(persistencia,
				llamada);
		this.persistencia = persistencia;
		this.llamada = llamada;
		addCampo(fllamada.crearCampoLlamadaContacto());
		addCampo(fllamada.crearCampoLlamadaFechaLlamada());
		addCampo(fllamada.crearCampoLlamadaAsunto());
		addCampo(fllamada.crearCampoLlamadaNotas());
	}

	@Override
	protected boolean crear() {
		return (persistencia.newLlamada(llamada) > 0)?true:false;
	}

	@Override
	protected boolean actualizar() {
		return persistencia.updateLlamada(llamada);
	}
}
