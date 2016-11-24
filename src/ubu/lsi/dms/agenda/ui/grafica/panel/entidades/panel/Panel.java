package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.persistencia.Persistencia;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ILista;

/**
 * Es la parte visible que interactua con el usuario, en el aparecen los campos
 * de la entidad a la que pertenece. Deja siempre sin editar el primer campo que
 * aparece, que deberá ser el id.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class Panel {

	/**
	 * Panel sobre el que se dibujanlos campos
	 */
	protected JLayeredPane panel;
	/**
	 * Posición donde se imprime el siguiente campo
	 */
	private int posicionY;

	/**
	 * Separación entre campos
	 */
	private int separacion;

	/**
	 * Indica si el registro se puede editar
	 */
	private boolean editable;

	/**
	 * Referencia a la lista con la que se intercambiaran los datos.
	 */
	private ILista lista;

	/**
	 * Referencia a la persistencia, por si necesita realizar alguna
	 * comprobación.
	 */
	protected FachadaPersistente persistencia;

	protected Panel(JTabbedPane tabbedPane, String etiqueta, ILista lista) {
		// Crea y asocia el panel al contenedor de paneles
		panel = new JLayeredPane();
		tabbedPane.addTab(etiqueta, null, panel, null);
		posicionY = 10; // Posición del elemento a mostrar
		separacion = 20; // Separación de linea entre elementos
		this.lista = lista;
		persistencia = Persistencia.getPersistencia();
	}

	/**
	 * Añade un campo de texto al panel de entidad.
	 * 
	 * @param etiqueta
	 * @return una referencia al campo
	 */
	protected JTextField addCampo(String etiqueta) {
		JLabel label = new JLabel(etiqueta);
		label.setBounds(10, posicionY, 100, 19);
		panel.add(label);
		JTextField nombre = new JTextField();
		nombre.setBounds(100, posicionY, 160, 19);
		nombre.setColumns(10);
		panel.add(nombre);
		posicionY += separacion;
		return nombre;
	}

	/**
	 * Convierte en editables o no los campos de texto. El primero siempre lo
	 * trata como id y deshabilita la edición. Si el estado pedido es el mismo
	 * que tiene no hace nada.
	 * 
	 * @param editar
	 */
	public void setEditable(boolean editar) {
		if (!(editar & isEditable())) {
			Component[] componentes = panel.getComponents();
			boolean id = true;
			for (Component e : componentes) {
				if (JTextField.class.isInstance(e)) {
					if (id) {
						((JTextField) e).setEditable(false);
						id = false;
					} else {
						((JTextField) e).setEditable(editar);
					}
				}
			}
		}
		editable = editar;
	}

	/**
	 * Devuelve una referencia de este panel
	 * 
	 * @return
	 */
	public JLayeredPane getPanel() {
		return panel;
	}

	/**
	 * Devuelve si el registro representado en el panel es editable
	 * 
	 * @return
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Visualiza u oculta los campos del panel
	 * 
	 * @param visible
	 */
	private void habilitar(boolean visible) {
		Component[] componentes = panel.getComponents();
		for (Component e : componentes) {
			e.setVisible(visible);
		}
		panel.setVisible(visible);
	}

	/**
	 * Asegura que se visualicen los datos correctos y que el estado de las
	 * banderas sea coherente.
	 */
	public void actualizaVistaPanel() {
		if (lista.longitudLista() > 0) {
			sincronizaCamposPanel();
			habilitar(true);
			if (lista.getId() > 0) {
				setEditable(false);
			} else {
				setEditable(true);
			}
		} else {
			habilitar(false);
			setEditable(false);
		}
	}

	protected abstract void sincronizaCamposPanel();

	public abstract void sincronizaRegistroSeleccionado();

}
