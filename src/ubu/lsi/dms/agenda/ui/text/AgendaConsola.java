package ubu.lsi.dms.agenda.ui.text;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.persistencia.Persistencia;
import ubu.lsi.dms.agenda.ui.text.menus.*;

/**
 * Aplicación de agenda, para llevar el mantenimiento de datos de contactos y de
 * llamadas en una base de datos, que se puede elegir.
 * 
 * @author José Ramón Cuevas diez
 * 
 */
public class AgendaConsola {

	// referencias a las instancias de los menús
	private static FachadaPersistente persistencia;
	private static MenuCrearContacto crearContacto;
	private static MenuCrearLlamada crearLlamada;
	private static MenuCrearTipoContacto crearTipoContacto;
	private static MenuBuscaActualizaContacto actualizarContacto;
	private static MenuBuscaActualizaLlamada actualizarLlamada;
	private static MenuBuscaActualizaTipoContacto actualizarTipoContacto;
	private static MenuListarContactos listadoContactos;
	private static MenuListarLlamadas listadoLlamadas;
	private static MenuListarTiposContacto listadoTiposContacto;
	private static MenuOpciones principal;
	private static MenuOpciones insertar;
	private static MenuOpciones actualizar;
	private static MenuOpciones consultar;

	// Para iniciar la aplicación hay que llamarla con un parámetro
	// BBDD para persistencia con la base de datos HSQLDB
	// BIN para persistencia con un fichero binario
	public static void main(String[] args) {
		
		// Inicializaciones de elementos
		persistencia = Persistencia.getPersistencia();
		inicializarOpciones();
		inicializarMenus();
		inicializarOpcionesMenus();

		// Mostrar menú principal
		principal.mostrar();
	}

	/**
	 * Creación de las opciones de los menus
	 */
	private static void inicializarOpcionesMenus() {
		// Opciones de menu insertar
		insertar.addOpcion("Nuevo Contacto", new GoTo(crearContacto));
		insertar.addOpcion("Nueva Llamada", new GoTo(crearLlamada));
		insertar.addOpcion("Nuevo Tipo de Contacto",
				new GoTo(crearTipoContacto));
		insertar.addOpcion("Volver", new GoTo(principal));

		// Opciones de menu actualizar
		actualizar.addOpcion("Actualizar Contacto",
				new GoTo(actualizarContacto));
		actualizar.addOpcion("Actualizar Llamada", new GoTo(actualizarLlamada));
		actualizar.addOpcion("Actualizar Tipo de Contacto", new GoTo(
				actualizarTipoContacto));
		actualizar.addOpcion("Volver", new GoTo(principal));

		// Opciones de menu consultar
		consultar.addOpcion("Consultar Contactos por apellido", new GoTo(
				listadoContactos));
		consultar.addOpcion("Consultar Llamadas por contacto", new GoTo(
				listadoLlamadas));
		consultar.addOpcion("Consultar Tipos de Contacto", new GoTo(
				listadoTiposContacto));
		consultar.addOpcion("Volver", new GoTo(principal));

		// Opciones de menu principal
		principal.addOpcion("Insertar", new GoTo(insertar));
		principal.addOpcion("Actualizar", new GoTo(actualizar));
		principal.addOpcion("Consultar", new GoTo(consultar));
		principal.addOpcion("Salir", new End());

	}

	/**
	 * Crea instancias de los menús que se usaran en la aplicación
	 */
	private static void inicializarMenus() {
		principal = new MenuOpciones("Menu Principal");
		insertar = new MenuOpciones("Menu Insertar");
		actualizar = new MenuOpciones("Menu Actualizar");
		consultar = new MenuOpciones("Menu Consultar");
	}

	/**
	 * Crea instancias de los formularios usados en la aplicación
	 */
	private static void inicializarOpciones() {
		crearContacto = new MenuCrearContacto(persistencia);
		crearLlamada = new MenuCrearLlamada(persistencia);
		crearTipoContacto = new MenuCrearTipoContacto(persistencia);
		actualizarContacto = new MenuBuscaActualizaContacto(persistencia);
		actualizarLlamada = new MenuBuscaActualizaLlamada(persistencia);
		actualizarTipoContacto = new MenuBuscaActualizaTipoContacto(
				persistencia);
		listadoContactos = new MenuListarContactos(persistencia);
		listadoLlamadas = new MenuListarLlamadas(persistencia);
		listadoTiposContacto = new MenuListarTiposContacto(persistencia);
	}

	
	/**
	 * Finalización correcta de la aplicación
	 */
	public static void finalizar(){
		Persistencia.close();
	}

}
