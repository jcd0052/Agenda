package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad;

import javax.swing.JTabbedPane;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaLlamada;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones.OperacionesListaLlamada;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel.PanelLlamada;

/**
 * Montaje concreto de una entidad gráfica de Llamada
 * 
 * @author José Ramón Cuevas Diez
 *
 */
public class EntidadGuiLlamada extends EntidadGui {

	public EntidadGuiLlamada(JTabbedPane tabbedPane) {
		super(tabbedPane);
		operacion = new OperacionesListaLlamada();
		lista = operacion.getLista();
		panel = new PanelLlamada(tabbedPane, (ListaLlamada) lista);
	}

}
