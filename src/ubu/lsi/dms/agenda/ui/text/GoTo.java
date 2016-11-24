package ubu.lsi.dms.agenda.ui.text;

/**
 * Comando utilizado para hiperenlace en las opciones de menu.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class GoTo implements Comando {

	private IElemento siguiente;

	public GoTo(IElemento siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public void ejecutar() {
		siguiente.mostrar();
	}

}
