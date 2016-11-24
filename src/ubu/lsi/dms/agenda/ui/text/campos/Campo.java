package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.ui.text.Elemento;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.Teclado;
import ubu.lsi.dms.agenda.ui.text.campos.Campo;

/**
 * Define el comportamiento común de los campos mostrados por pantalla
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class Campo extends Elemento {
	protected String etiqueta;
	protected String valor;

	protected Campo(String etiqueta) {
		this.etiqueta = etiqueta;
		this.teclado = Teclado.getInstance();
	}

	@Override
	public void mostrar() {
		tomaValor();
		System.out.print(etiqueta + "[" + valor + "]: ");
		try {
			setValor();
		} catch (ReturnException e) {
			// System.out.println(valor);
		} finally {
			siguiente();
		}
	}

	protected abstract void tomaValor();

	protected abstract void setValor() throws ReturnException;

}
