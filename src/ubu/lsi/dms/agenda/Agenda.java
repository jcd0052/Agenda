package ubu.lsi.dms.agenda;

import ubu.lsi.dms.agenda.persistencia.Persistencia;
import ubu.lsi.dms.agenda.ui.InterfazUsuario;

/**
 * Aplicación de agenda para llevar el matenimiento de contactos y llamadas. La
 * ejecución se efctua con la siguiente línea:
 * 
 * java -jar Agenda.jar basedatos interface
 * 
 * Parámetros: basedatos indica que capa de persistencia utilizar BBDD base de
 * datos HSQL BIN fichero binario interface indica que interface de usuario
 * utilizar TUI consola de texto GUI ventana gráfica
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class Agenda {

	/**
	 * @param args
	 *            parámetros de la aplicación.
	 */
	public static void main(String[] args) {

		if (args.length == 2 && esParametro0(args[0]) && esParametro1(args[1])) {
			// Indicamos a la capa de persistencia que tipo queremos utilizar
			Persistencia.setTipo(args[0]);
			InterfazUsuario.arrancaInterfaz(args[1]);
		} else {
			mostrarAyuda();
			System.exit(-1);
		}

	}

	public static boolean esParametro0(String args0) {
		return (args0.equals(Persistencia.Tipo.BBDD.toString()) || args0
				.equals(Persistencia.Tipo.BIN.toString()));
	}

	public static boolean esParametro1(String args1) {
		return (args1.equals(InterfazUsuario.Tipo.TUI.toString()) || args1
				.equals(InterfazUsuario.Tipo.GUI.toString()));
	}

	public static void mostrarAyuda() {
		String ayuda = " Aplicación de agenda para llevar el matenimiento de contactos y llamadas.\n"
				+ " La ejecución se efctua con la siguiente línea:\n"
				+ "\n"
				+ " java -jar Agenda.jar basedatos interface\n"
				+ "\n"
				+ "Parámetros:\n"
				+ "    basedatos indica que capa de persistencia utilizar\n"
				+ " 				BBDD base de datos HSQL\n"
				+ " 				BIN fichero binario\n"
				+ "    interface indica que interface de usuario utilizar\n"
				+ " 				TUI consola de texto\n"
				+ " 				GUI ventana gráfica\n"
				+ "\n"
				+ "Si se utiliza la opción BBDD debe haber arrancado localmente un servidor HSQLdb\n"
				+ "Conteniendo una base de datos Agenda según especificaciones del manual de usuario.\n"
				+ "\n"
				+ " @author José Ramón Cuevas Diez\n"
				+ "  4º Curso G.I.I. UBU\n";
		System.out.println(ayuda);
	}
}
