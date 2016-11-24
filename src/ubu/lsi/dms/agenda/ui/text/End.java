package ubu.lsi.dms.agenda.ui.text;

/**
 * Comando usado para salir de la aplicación, en las opciones de menú
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class End implements Comando {

	@Override
	public void ejecutar() {
		AgendaConsola.finalizar();
		System.exit(0);
	}

}
