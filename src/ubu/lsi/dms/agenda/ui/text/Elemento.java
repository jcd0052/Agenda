package ubu.lsi.dms.agenda.ui.text;

/**
 * Cualquier objeto de la interfaz de texto, se considera un elemento y aquí se
 * definen las características comunes.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class Elemento implements IElemento {

	protected IElemento siguiente;
	protected Teclado teclado;

	/**
	 * Todo elemento tiene asociada la misma instancia del teclado.
	 */
	protected Elemento() {
		this.teclado = Teclado.getInstance();
	}

	/**
	 * Indica cual será el próximo elemento a mostrar
	 */
	@Override
	public void setSiguiente(IElemento siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Muestra el siguiente elemento por pantalla
	 */
	@Override
	public void siguiente() {
		if (siguiente != null) {
			this.siguiente.mostrar();
		}
	}
}
