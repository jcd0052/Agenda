package ubu.lsi.dms.agenda.ui.grafica.panel.entidades;

import javax.swing.JTextField;

/**
 * Utilidades que se necesitan para distintas partes del interface gráfico.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class Utilidades {

	/**
	 * Devuelve el valor del campo
	 * 
	 * @param campo
	 * @return valor del campo, si no es numérico 0.
	 */
	public static int getValorCampo(JTextField campo) {
		return getValor(campo.getText());
	}

	/**
	 * Devuelve el valor del texto
	 * 
	 * @param texto
	 * @return valor del campo, si no es numérico 0.
	 */
	public static int getValor(String texto) {
		int resultado;
		try {
			resultado = Integer.valueOf(texto);
		} catch (NumberFormatException e) {
			resultado = 0;
		}
		return resultado;
	}
}
