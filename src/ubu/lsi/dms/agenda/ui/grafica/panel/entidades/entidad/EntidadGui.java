package ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad;

import java.util.Observable;
import javax.swing.JTabbedPane;
import ubu.lsi.dms.agenda.ui.grafica.acciones.Accion;
import ubu.lsi.dms.agenda.ui.grafica.acciones.IComandos;
import ubu.lsi.dms.agenda.ui.grafica.acciones.ICommand;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.lista.ILista;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.operaciones.OperacionesLista;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.panel.Panel;

/**
 * Clase abstracta que define el contexto en el que se desenvolverá cada
 * panelEntidad. Cada EntidadGui dispone de una lista de registros, que puede
 * estar vacia o tener varios registros. Estos registros son el resultado de las
 * consultas o inserciones realizadas.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class EntidadGui extends Observable implements ICommand,
		IComandos {
	/**
	 * Siguiente entidad enlazada
	 */
	protected EntidadGui siguienteEntidadGui;
	/**
	 * Panel de pestañas sobre el que irá el panel de cada entidad
	 */
	protected JTabbedPane tabbedPane;
	/**
	 * Lista que contiene los registros a visualizar o editar
	 */
	protected ILista lista;
	/**
	 * Acceso a las operaciones que se pueden realizar con la lista
	 */
	protected OperacionesLista operacion;
	/**
	 * Panel que muestra los campos del registro seleccionado y el usuario
	 * interactúa.
	 */
	protected Panel panel;

	/**
	 * Constructor que monta el panel de campos sobre el de pestañas
	 * 
	 * @param tabbedPane
	 * @param etiqueta
	 *            Texto que aparecerá en la pestaña
	 */
	public EntidadGui(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	// METODOS RELACIONADOS CON LA PROPIA ENTIDAD

	/**
	 * Setea cual es la siguiente entidad de la lista enlazada
	 * 
	 * @param siguiente
	 */
	public void setNextEntidadGui(EntidadGui siguiente) {
		this.siguienteEntidadGui = siguiente;
	}

	/**
	 * Marca el objeto como modificado y notifica a los observadores.
	 */
	public void objetoModificado() {
		// Marca el objeto como cambiado y notifica a los observadores
		setChanged();
		notifyObservers(this);
	}

	// COMPROBACIONES DEL ESTADO DE LA ENTIDAD

	/**
	 * Comprueba si esta entidad está seleccionada y visible en el panel del
	 * usuario.
	 * 
	 * @return true en caso de ser la visible
	 */
	private boolean isSeleccionada() {
		return tabbedPane.getSelectedComponent().equals(panel.getPanel());
	}

	/**
	 * Comprueba si hay algún registro o si el registro seleccionado es nuevo.
	 * 
	 * @return true en caso de que exista algún registro y el seleccionado sea
	 *         nuevo.
	 */
	public boolean isRegistroNuevo() {
		return (lista.longitudLista() == 0) ? false : (lista.getId() == 0);
	}

	/**
	 * Devuelve si el registro es editable
	 * 
	 * @return
	 */
	public boolean isEditable() {
		return panel.isEditable();
	}

	/**
	 * Informa del número de orden del registro seleccionado
	 * 
	 * @return
	 */
	public int getRegistroSeleccionado() {
		return lista.getRegistroSeleccionado();
	}

	/**
	 * Informa de la cantidad de campos que hay en la lista
	 * 
	 * @return
	 */
	public int longitudLista() {
		return lista.longitudLista();
	}

	// MÉTODOS RELACIONADOS CON LAS ACCIONES A REALIZAR

	@Override
	public void realizar(Accion accion) {
		// Si esta es la entidad visible actualmente
		if (isSeleccionada()) {
			// Ejecuta acción
			accion.ejecutar(this);
			objetoModificado();
		} else if (siguienteEntidadGui != null) {
			siguienteEntidadGui.realizar(accion);
		}
	}

	@Override
	public void nuevo() {
		lista.creaNuevoRegistro();
		panel.actualizaVistaPanel();
		panel.setEditable(true);
	}

	@Override
	public void insertar() {
		panel.sincronizaRegistroSeleccionado();
		lista.setId(operacion.insertaRegistroBBDD());
		panel.actualizaVistaPanel();
	}

	@Override
	public void editar() {
		panel.setEditable(true);
	}

	@Override
	public void actualizar() {
		panel.sincronizaRegistroSeleccionado();
		if (operacion.actualizaRegistroBBDD()) {
			panel.setEditable(false);
		}
	}

	@Override
	public void consultar(String texto) {
		operacion.consultarBBDD(texto);
		panel.actualizaVistaPanel();
	}

	@Override
	public void cancelar() {
		// Si es un registro nuevo lo elimina
		if (lista.getId() == 0) {
			lista.creaListaVacia();
		}
		panel.actualizaVistaPanel();
	}

	@Override
	public void siguiente() {
		lista.siguiente();
		panel.actualizaVistaPanel();
	}

	@Override
	public void atras() {
		lista.atras();
		panel.actualizaVistaPanel();
	}
}