package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.Utilidades;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaTipoContacto;

/**
 * Clase que contiene los datos y acciones específicas de la entidad tipoContacto.
 * 
 * @author José Ramón Cuevas Diez
 *
 */
public class PanelTipoContacto extends Panel {
	private JTextField idTipoContacto;
	private JTextField tipoContacto;

	private ListaTipoContacto listaTiposContacto;

	public PanelTipoContacto(JTabbedPane tabbedPane, ListaTipoContacto lista) {
		super(tabbedPane, "TipoContacto", lista);
		this.listaTiposContacto = lista;
		
		idTipoContacto = addCampo("idTipoCont:");
		idTipoContacto.setEditable(false);

		tipoContacto = addCampo("Tipo Contac:");
		
		actualizaVistaPanel();
	}

	@Override
	protected void sincronizaCamposPanel() {
		TipoContacto aux = listaTiposContacto.getRegistroSelecionado();
		// Realiza la actualización
		idTipoContacto.setText(String.valueOf(aux.getIdTipoContacto()));
		tipoContacto.setText(aux.getTipoContacto());
	}

	@Override
	public void sincronizaRegistroSeleccionado() {
		TipoContacto aux = listaTiposContacto.getRegistroSelecionado();
		// Realiza la actualización
		aux.setIdTipoContacto(Utilidades.getValorCampo(idTipoContacto));
		aux.setTipoContacto(tipoContacto.getText());
	}

}
