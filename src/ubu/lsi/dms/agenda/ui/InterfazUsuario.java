package ubu.lsi.dms.agenda.ui;

import ubu.lsi.dms.agenda.ui.grafica.AgendaGUI;
import ubu.lsi.dms.agenda.ui.text.AgendaConsola;

/**
 * Selector de interfaz de usuario a utilizar
 * 
 * @author José Ramón Cuevas Diez
 *
 */
public class InterfazUsuario {

	public enum Tipo {
		TUI, GUI
	};

	/**
	 * @param args
	 */
	public static void arrancaInterfaz(String tipo) {

		switch (tipo) {
			case "TUI":
				AgendaConsola.main(null);
				break;
			case "GUI":
				AgendaGUI.main(null);
		}

	}

}
