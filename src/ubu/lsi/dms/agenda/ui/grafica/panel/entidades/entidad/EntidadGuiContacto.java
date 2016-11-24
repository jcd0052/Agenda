package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad;

import javax.swing.JTabbedPane;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaContacto;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones.OperacionesListaContacto;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel.PanelContacto;

/**
 * Montaje concreto de una entidad gráfica de Contacto
 * 
 * @author José Ramón Cuevas Diez
 *
 */
public class EntidadGuiContacto extends EntidadGui {

	public EntidadGuiContacto(JTabbedPane tabbedPane) {
		super(tabbedPane);
		operacion = new OperacionesListaContacto();
		lista = operacion.getLista();
		panel = new PanelContacto(tabbedPane, (ListaContacto) lista);
	}

}
