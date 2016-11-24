package ubu.lsi.dms.agenda.ui.grafica.acciones;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGui;

/**
 * Esta clase contiene la información en formato texto que se quiere buscar. El
 * objeto que lo recibe llama al método ejecutar facilitando su propia
 * referencia.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class AccionConsultar implements Accion {
	String texto;

	/**
	 * Constructor al que se le facilita el texto a buscar.
	 * 
	 * @param texto
	 */
	public AccionConsultar(String texto) {
		this.texto = texto;
	}

	@Override
	public void ejecutar(EntidadGui entidad) {
		entidad.consultar(texto);
	}

}
