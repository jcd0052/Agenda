package ubu.lsi.dms.agenda.ui.text.menus;

import java.util.LinkedList;
import java.util.List;

import ubu.lsi.dms.agenda.ui.text.Comando;
import ubu.lsi.dms.agenda.ui.text.Elemento;
import ubu.lsi.dms.agenda.ui.text.ReturnException;

/**
 * Genera un menu de opciones al que se le agregan las opciones del menu
 * deseadas y el comando a ejecutar si se elije esa opción.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuOpciones extends Elemento {
	private List<OpcionMenu> opciones = new LinkedList<OpcionMenu>();
	private int orden;
	private String titulo;

	public MenuOpciones(String titulo) {
		this.orden = 0;
		this.titulo = titulo;
		this.siguiente = this;
	}

	public void addOpcion(String descripcion, Comando comando) {
		opciones.add(new OpcionMenu(++orden, descripcion, comando));
	}

	@Override
	public void mostrar() {
		System.out.println("------| " + titulo + " |------");
		for (OpcionMenu e : opciones) {
			System.out.println(e.getLinea());
		}
		System.out.print("\nElije la opción deseada: ");
		try {
			int seleccion = teclado.getInt();
			for (OpcionMenu opcion : opciones) {
				if (seleccion == opcion.numero) {
					System.out.println("");
					opcion.comando.ejecutar();
				}
			}
		} catch (ReturnException e1) {
			siguiente();
		} finally {
			siguiente();
		}
	}

	private class OpcionMenu {
		private int numero;
		private String descripcion;
		private Comando comando;

		private OpcionMenu(int numero, String descripcion, Comando comando) {
			this.numero = numero;
			this.descripcion = descripcion;
			this.comando = comando;
		}

		private String getLinea() {
			return numero + " " + descripcion;
		}
	}

}
