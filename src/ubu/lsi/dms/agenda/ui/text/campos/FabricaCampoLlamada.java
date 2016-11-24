package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.*;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

/**
 * Fábrica para crear los campos correspondientes a la entidad CampoLlamada,
 * estos campos se utilizan en los formularios para mostrar el valor actual y
 * recoger el que el usuario introduzca por teclado.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FabricaCampoLlamada {

	private Llamada llamada;
	private FachadaPersistente persistencia;

	public FabricaCampoLlamada(FachadaPersistente persistencia, Llamada llamada) {
		this.llamada = llamada;
		this.persistencia = persistencia;
	}

	public Campo crearCampoLlamadaIdLlamada() {
		return new CampoLlamadaIdLlamada(llamada);
	}

	public Campo crearCampoLlamadaContacto() {
		return new CampoLlamadaContacto(llamada, persistencia);
	}

	public Campo crearCampoLlamadaFechaLlamada() {
		return new CampoLlamadaFechaLlamada(llamada);
	}

	public Campo crearCampoLlamadaAsunto() {
		return new CampoLlamadaAsunto(llamada);
	}

	public Campo crearCampoLlamadaNotas() {
		return new CampoLlamadaNotas(llamada);
	}

}
