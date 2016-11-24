package ubu.lsi.dms.agenda.ui.text;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que se ocupa de leer del teclado
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class Teclado {

	private static Teclado teclado;
	private Scanner sc;

	private Teclado() {
		sc = new Scanner(System.in);
	}

	/**
	 * Devuelve una instancia de teclado única para toda la aplicación.
	 * 
	 * @return instancia de teclado.
	 */
	public static Teclado getInstance() {
		if (teclado == null) {
			teclado = new Teclado();
		}
		return teclado;
	}

	/**
	 * Espera hasta que se introduce un texto compuesto por cualquier caracter
	 * imprimible.
	 * 
	 * @return texto introducido por teclado
	 * @throws ReturnException
	 *             si se pulsa intro al principio de linea
	 */
	public String getString() throws ReturnException {
		return capturaTeclado("^.*$");
		// return capturaTeclado("^([A-Za-z0-9]*\\s*)+$");
		// return capturaTeclado("^{graph}*$");
	}

	/**
	 * Espera hasta que se introduce un número
	 * 
	 * @return número introducido por teclado
	 * @throws ReturnException
	 *             si se pulsa intro al principio de linea
	 */
	public int getInt() throws ReturnException {
		return Integer.parseInt(capturaTeclado("^[0-9]*$"));
	}

	/**
	 * Espera que se introduzca s o n
	 * 
	 * @return true si se ha introducido s o S
	 * @throws ReturnException
	 *             si se pulsa intro al principio de linea
	 */
	public boolean getAceptar() throws ReturnException {
		return (capturaTeclado("[snSN]").matches("[sS]")) ? true : false;
	}

	// Los siguientes métodos realizan las mismas operaciones que los anteriores
	// pero sacando el texto pasado por parámetro.

	public int getInt(String descripcion) throws ReturnException {
		System.out.print(descripcion);
		return getInt();
	}

	public boolean getAceptar(String descripcion) throws ReturnException {
		System.out.print(descripcion);
		return getAceptar();
	}

	public String getString(String descripcion) throws ReturnException {
		System.out.print(descripcion);
		return getString();
	}

	public void pausa() {
		System.out.print("\nPulsa enter para continuar.");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

	/**
	 * Captura del teclado las teclas pulsadas.
	 * 
	 * @param filtro
	 *            Expresión regular que indica el texto esperado.
	 * @return texto capturado del teclado
	 * @throws ReturnException
	 *             si se pulsa intro al principio de linea
	 */
	private String capturaTeclado(String filtro) throws ReturnException {
		String in = "";
		sc.reset();
		while (in.equals("")) {
			in = sc.nextLine();
			if (in.equals("")) {
				throw new ReturnException();
			}
			if (!in.matches(filtro)) {
				System.out.println("Entrada no esperada.");
				in = "";
			}
		}
		return in;
	}
}
