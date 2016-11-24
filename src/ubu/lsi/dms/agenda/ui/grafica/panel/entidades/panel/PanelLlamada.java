package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.Utilidades;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaLlamada;

/**
 * Clase que contiene los datos y acciones específicas de la entidad llamada.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class PanelLlamada extends Panel implements ActionListener,
		FocusListener {
	private JTextField idLlamada;
	private JTextField fechaLlamada;
	private JTextField asunto;
	private JTextField notas;
	private JTextField contacto;
	private String oldContacto;

	private ListaLlamada listaLlamadas;

	public PanelLlamada(JTabbedPane tabbedPane, ListaLlamada lista) {
		super(tabbedPane, "Llamada", lista);
		this.listaLlamadas = lista;

		idLlamada = addCampo("idLlamada:");
		idLlamada.setEditable(false);

		fechaLlamada = addCampo("Fecha:");

		asunto = addCampo("Asunto:");

		notas = addCampo("Notas:");

		contacto = addCampo("Contacto:");
		// contacto.addActionListener(this);
		// contacto.addFocusListener(this);

		actualizaVistaPanel();
	}

	@Override
	protected void sincronizaCamposPanel() {
		Llamada aux = listaLlamadas.getRegistroSelecionado();

		idLlamada.setText(String.valueOf(aux.getIdLlamada()));
		fechaLlamada.setText(aux.getFechaLlamada());
		asunto.setText(aux.getAsunto());
		notas.setText(aux.getNotas());
		if (aux.getContacto() != null) {
			contacto.setText(String.valueOf(aux.getContacto().getIdContacto()));
		} else {
			contacto.setText("");
		}

	}

	@Override
	public void sincronizaRegistroSeleccionado() {
		Llamada aux = listaLlamadas.getRegistroSelecionado();

		aux.setIdLlamada(Utilidades.getValorCampo(idLlamada));
		aux.setFechaLlamada(fechaLlamada.getText());
		aux.setAsunto(asunto.getText());
		aux.setNotas(notas.getText());
		aux.setContacto(persistencia.getContacto(Utilidades
				.getValorCampo(contacto)));
	}

	// TRATAMIENTO DE EVENTOS

	@Override
	public void actionPerformed(ActionEvent e) {
		// Si se pulsa intro pasa el foco
		contacto.transferFocus();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// Toma el texto que hay al coger el foco
		oldContacto = contacto.getText();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// Si al salir del campo el texto ha cambiado
		if (!contacto.getText().equals(oldContacto)) {
			Contacto aux = persistencia.getContacto(Utilidades
					.getValorCampo(contacto));
			if (aux == null) {
				contacto.setText("");
			}
		}

	}

}
