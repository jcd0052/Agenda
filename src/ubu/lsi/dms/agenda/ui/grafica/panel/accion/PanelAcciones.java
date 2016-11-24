package ubu.lsi.dms.agenda.ui.grafica.panel.accion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ubu.lsi.dms.agenda.ui.grafica.acciones.*;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGui;

/**
 * Panel que contiene los botones para interactuar con el usuario. El usuario
 * recibe información por el campoInfo y puede enviar consultas por el
 * campoBuscar.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class PanelAcciones implements ActionListener, Observer {
	private JPanel panel;
	private JButton botonNuevo;
	private JButton botonInsertar;
	private JButton botonEditar;
	private JButton botonActualizar;
	private JButton botonCancelar;
	private JTextField campoBuscar;
	private JButton botonConsultar;
	private JButton botonAtras;
	private JTextField campoInfo;
	private JButton botonSiguiente;

	private ICommand receptorAcciones; // Objeto sobre el que realizar
										// acciones

	public PanelAcciones(JPanel contentPane) {

		// Panel contenedor
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// Botones de Nuevo, Insertar, Edita, Actualizar y Consultar
		botonNuevo = addBoton("Nuevo");

		botonInsertar = addBoton("Insertar");

		botonEditar = addBoton("Editar");

		botonActualizar = addBoton("Actualizar");

		botonCancelar = addBoton("Cancelar");

		campoBuscar = addCampoTexto();

		botonConsultar = addBoton("Consultar");

		// Ancho del panel contenedor
		panel.add(Box.createHorizontalStrut(150));
		// Relleno de espacio
		panel.add(Box.createVerticalGlue());

		// Botones de atras, adelante y campoInfo
		botonAtras = addBoton("Atras");

		campoInfo = addCampoTexto();
		campoInfo.setEditable(false);

		botonSiguiente = addBoton("Siguiente");
	}

	/**
	 * Añade al panel un campo de texto
	 * 
	 * @return la referencia al campo de texto
	 */
	private JTextField addCampoTexto() {
		JTextField campo = new JTextField();
		campo.setMaximumSize(new Dimension(150, 25));
		campo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(campo);
		campo.setColumns(10);
		return campo;
	}

	/**
	 * Añade un botón al tablero
	 * 
	 * @param nombre
	 * @return la referencia al botón recien creado.
	 */
	private JButton addBoton(String nombre) {
		JButton boton = new JButton(nombre);
		boton.setMaximumSize(new Dimension(150, 25));
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton.addActionListener(this);
		panel.add(boton);
		return boton;
	}
	
	/**
	 * Añade el objeto sobre el que ejecutar las acciones
	 * 
	 * @param receptorAcciones
	 */
	public void addReceptorAcciones(ICommand receptorAcciones) {
		this.receptorAcciones = receptorAcciones;
	}

	/**
	 * Las pulsaciones sobre los botones disparan esta acción que se encarga de
	 * comprobar que botón se ha pulsado y envia la orden correspondiente al
	 * objeto receptor de acciones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton aux = (JButton) e.getSource();
		switch (aux.getText()) {
		case "Siguiente":
			receptorAcciones.realizar(new AccionSiguiente());
			break;
		case "Atras":
			receptorAcciones.realizar(new AccionAtras());
			break;
		case "Nuevo":
			receptorAcciones.realizar(new AccionNuevo());
			break;
		case "Insertar":
			receptorAcciones.realizar(new AccionInsertar());
			break;
		case "Editar":
			receptorAcciones.realizar(new AccionEditar());
			break;
		case "Actualizar":
			receptorAcciones.realizar(new AccionActualizar());
			break;
		case "Cancelar":
			receptorAcciones.realizar(new AccionCancelar());
			break;
		case "Consultar":
			receptorAcciones
					.realizar(new AccionConsultar(campoBuscar.getText()));
			campoBuscar.setText("");
			break;
		}
	}

	/**
	 * Cuando el objeto observado cambia, se recibe por este método, entonces se
	 * realiza una consulta de los parámetros que afectan a este módulo para la
	 * visualización coherente de acciones.
	 */
	@Override
	public void update(Observable o, Object arg) {
		EntidadGui aux = ((EntidadGui) arg);
		campoInfo.setText(" Registro " + (aux.getRegistroSeleccionado() + 1)
				+ " de " + aux.longitudLista());
		// Estados del objeto
		if (aux.longitudLista() == 0) {
			botonNuevo.setEnabled(true);
			botonInsertar.setEnabled(false);
			botonEditar.setEnabled(false);
			botonActualizar.setEnabled(false);
			botonCancelar.setEnabled(false);
			campoBuscar.setEditable(true);
			botonConsultar.setEnabled(true);
			botonAtras.setEnabled(false);
			botonSiguiente.setEnabled(false);
		} else if (aux.isRegistroNuevo()) {
			botonNuevo.setEnabled(false);
			botonInsertar.setEnabled(true);
			botonEditar.setEnabled(false);
			botonActualizar.setEnabled(false);
			botonCancelar.setEnabled(true);
			campoBuscar.setEditable(false);
			botonConsultar.setEnabled(false);
			botonAtras.setEnabled(false);
			botonSiguiente.setEnabled(false);
		} else if (aux.isEditable()) {
			botonNuevo.setEnabled(false);
			botonInsertar.setEnabled(false);
			botonEditar.setEnabled(false);
			botonActualizar.setEnabled(true);
			botonCancelar.setEnabled(true);
			campoBuscar.setEditable(false);
			botonConsultar.setEnabled(false);
			botonAtras.setEnabled(false);
			botonSiguiente.setEnabled(false);
		} else {
			botonNuevo.setEnabled(true);
			botonInsertar.setEnabled(false);
			botonEditar.setEnabled(true);
			botonActualizar.setEnabled(false);
			botonCancelar.setEnabled(false);
			campoBuscar.setEditable(true);
			botonConsultar.setEnabled(true);
			botonAtras.setEnabled(true);
			botonSiguiente.setEnabled(true);
		}
	}

}
