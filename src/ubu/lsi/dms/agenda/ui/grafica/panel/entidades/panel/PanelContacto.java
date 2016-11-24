package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.Utilidades;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ListaContacto;

/**
 * Clase que contiene los datos y acciones específicas de la entidad contacto.
 * 
 * @author José Ramón Cuevas Diez
 *
 */
public class PanelContacto extends Panel implements ActionListener,
		FocusListener {
	private JTextField idContacto;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField estimado;
	private JTextField direccion;
	private JTextField ciudad;
	private JTextField prov;
	private JTextField codPostal;
	private JTextField region;
	private JTextField pais;
	private JTextField nombreCompania;
	private JTextField cargo;
	private JTextField telefonoTrabajo;
	private JTextField extensionTrabajo;
	private JTextField telefonoMovil;
	private JTextField numFax;
	private JTextField nomCorreoElectronico;
	private JTextField notas;
	private JTextField tipoContacto;
	private String oldTipoContacto;

	private ListaContacto listaContactos;

	public PanelContacto(JTabbedPane tabbedPane, ListaContacto lista) {
		super(tabbedPane, "Contacto", lista);
		this.listaContactos = lista;

		idContacto = addCampo("idContacto:");
		idContacto.setEditable(false);

		nombre = addCampo("Nombre:");

		apellidos = addCampo("Apellidos:");

		estimado = addCampo("Estimado:");

		direccion = addCampo("Dirección:");

		ciudad = addCampo("Ciudad:");

		prov = addCampo("Provincia:");

		codPostal = addCampo("C. Postal:");

		region = addCampo("Región:");

		pais = addCampo("Pais:");

		nombreCompania = addCampo("Compañia:");

		cargo = addCampo("Cargo:");

		telefonoTrabajo = addCampo("Tel. Trabajo:");

		extensionTrabajo = addCampo("Extensión:");

		telefonoMovil = addCampo("Movil:");

		numFax = addCampo("Fax:");

		nomCorreoElectronico = addCampo("Email:");

		notas = addCampo("Notas:");

		tipoContacto = addCampo("Tipo Contac:");
		//tipoContacto.addActionListener(this);
		//tipoContacto.addFocusListener(this);

		actualizaVistaPanel();
	}


	// SINCRONISMO

	@Override
	protected void sincronizaCamposPanel() {
		Contacto aux = listaContactos.getRegistroSelecionado();
		idContacto.setText(String.valueOf(aux.getIdContacto()));
		nombre.setText(aux.getNombre());
		apellidos.setText(aux.getApellidos());
		estimado.setText(aux.getEstimado());
		direccion.setText(aux.getDireccion());
		ciudad.setText(aux.getCiudad());
		prov.setText(aux.getProv());
		codPostal.setText(aux.getCodPostal());
		region.setText(aux.getRegion());
		pais.setText(aux.getPais());
		nombreCompania.setText(aux.getNombreCompania());
		cargo.setText(aux.getCargo());
		telefonoTrabajo.setText(aux.getTelefonoTrabajo());
		extensionTrabajo.setText(aux.getExtensionTrabajo());
		telefonoMovil.setText(aux.getTelefonoMovil());
		nomCorreoElectronico.setText(aux.getNomCorreoElectronico());
		notas.setText(aux.getNotas());
		if (aux.getTipoContacto() != null) {
			tipoContacto.setText(String.valueOf(aux.getTipoContacto()
					.getIdTipoContacto()));
		} else {
			tipoContacto.setText("");
		}
	}

	@Override
	public void sincronizaRegistroSeleccionado() {
		Contacto aux = listaContactos.getRegistroSelecionado();
		aux.setIdContacto(Utilidades.getValorCampo(idContacto));
		aux.setNombre(nombre.getText());
		aux.setApellidos(apellidos.getText());
		aux.setEstimado(estimado.getText());
		aux.setDireccion(direccion.getText());
		aux.setCiudad(ciudad.getText());
		aux.setProv(prov.getText());
		aux.setCodPostal(codPostal.getText());
		aux.setRegion(region.getText());
		aux.setPais(pais.getText());
		aux.setNombreCompania(nombreCompania.getText());
		aux.setCargo(cargo.getText());
		aux.setTelefonoTrabajo(telefonoTrabajo.getText());
		aux.setExtensionTrabajo(extensionTrabajo.getText());
		aux.setTelefonoMovil(telefonoMovil.getText());
		aux.setNumFax(numFax.getText());
		aux.setNomCorreoElectronico(nomCorreoElectronico.getText());
		aux.setNotas(notas.getText());
		aux.setTipoContacto(persistencia
				.getTipoContacto(Utilidades.getValorCampo(tipoContacto)));

	}

	// TRATAMIENTO DE EVENTOS

	@Override
	public void actionPerformed(ActionEvent e) {
		// Si se pulsa intro pasa el foco
		tipoContacto.transferFocus();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// Toma el texto que hay al coger el foco
		oldTipoContacto = tipoContacto.getText();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// Si al salir del campo el texto ha cambiado
		if (!tipoContacto.getText().equals(oldTipoContacto)) {
			TipoContacto aux = persistencia
					.getTipoContacto(Utilidades.getValorCampo(tipoContacto));
			if (aux == null) {
				tipoContacto.setText("");
			}
		}
	}

}
