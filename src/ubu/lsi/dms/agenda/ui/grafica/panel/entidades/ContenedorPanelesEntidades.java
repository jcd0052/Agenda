package ubu.lsi.dms.agenda.ui.grafica.panel.entidades;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ubu.lsi.dms.agenda.ui.grafica.acciones.Accion;
import ubu.lsi.dms.agenda.ui.grafica.acciones.ICommand;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGui;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGuiContacto;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGuiLlamada;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGuiTipoContacto;

/**
 * Clase que contiene los paneles de la entidades. En el se van añadiendo
 * entidades gráficas, que son con las que interactua el usuario. Estas se
 * muestran como pestañas que pueden ser selecionadas.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class ContenedorPanelesEntidades extends Observable implements ICommand,
		Observer, ChangeListener {
	private JTabbedPane tabbedPane;
	private EntidadGui[] entidades;

	public ContenedorPanelesEntidades(JPanel contentPane) {
		// Contenedor multiples paneles
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		// Añade los paneles de entidades al contenedor
		entidades = new EntidadGui[3];
		entidades[0] = new EntidadGuiContacto(tabbedPane);
		entidades[1] = new EntidadGuiLlamada(tabbedPane);
		entidades[2] = new EntidadGuiTipoContacto(tabbedPane);

		// Añade a las entidades observador y siguiente entidad enlazada
		for (int index = 0; index < entidades.length; index++) {
			entidades[index].addObserver(this);
			if (index < (entidades.length - 1)) {
				entidades[index].setNextEntidadGui(entidades[index + 1]);
			}
		}

		// Añade oyente para detectar cuando se pulsa una pestaña
		tabbedPane.addChangeListener(this);
	}

	@Override
	public void realizar(Accion accion) {
		// Envia el comando a la primera entidadGui y viaja en cadena por las
		// entidadesGui
		entidades[0].realizar(accion);
	}

	/**
	 * Este método es llamado cuando alguna entidad cambia A su vez avisa a los
	 * observadores suscritos a este objeto
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}

	/**
	 * Este método es llamado cuando se selecciona una pestaña
	 * 
	 * @param e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		entidades[tabbedPane.getSelectedIndex()].objetoModificado();
	}

}
