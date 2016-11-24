package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad;

import javax.swing.JTabbedPane;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaTipoContacto;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones.OperacionesListaTipoContacto;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel.PanelTipoContacto;

/**
 * Montaje concreto de una entidad gráfica de TipoContacto
 * 
 * @author José Ramón Cuevas Diez
 *
 */
public class EntidadGuiTipoContacto extends EntidadGui {

	public EntidadGuiTipoContacto(JTabbedPane tabbedPane) {
		super(tabbedPane);
		operacion = new OperacionesListaTipoContacto();
		lista = operacion.getLista();
		panel = new PanelTipoContacto(tabbedPane, (ListaTipoContacto) lista);
	}

}
