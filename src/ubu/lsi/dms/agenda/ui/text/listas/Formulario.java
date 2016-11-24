package ubu.lsi.dms.agenda.ui.text.listas;

import java.util.LinkedList;
import java.util.List;

import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.Elemento;
import ubu.lsi.dms.agenda.ui.text.IElemento;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.campos.Campo;

/**
 * Define la estructura de los formularios
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public abstract class Formulario extends Elemento {

	protected FachadaPersistente persistencia;
	protected IElemento primero;
	protected IElemento ultimo;
	protected List<Campo> campos;
	protected String titulo;
	private Accion accion;

	public Formulario(Campo primero, String titulo, Accion accion) {
		this.primero = primero;
		this.titulo = titulo;
		this.campos = new LinkedList<Campo>();
		this.accion = accion;
		addCampo(primero);
	}

	@Override
	public void mostrar() {
		System.out.println(titulo);
		System.out.println("-------------------------------");
		primero.mostrar();
		System.out.print("\nPulse s|n para aceptar: ");
		try {
			if (teclado.getAceptar()) {
				if (enviar()) {
					System.out.println("Datos guardados.");
				} else {
					System.out
							.println("Los datos no han podido ser guardados.");
				}
			} else {
				System.out.println("Operación cancelada por el usuario.");
			}
		} catch (ReturnException e) {
			System.out.println("Operación cancelada por el usuario.");
		} finally {
			System.out.println("");
		}
		siguiente();
	}

	protected void addCampo(Campo campo) {
		if (ultimo != null) {
			ultimo.setSiguiente(campo);
		}
		campos.add(campo);
		ultimo = campo;
	}

	private boolean enviar() {
		if (accion == Accion.CREAR) {
			return crear();
		} else {
			return actualizar();
		}
	}

	protected abstract boolean crear();

	protected abstract boolean actualizar();

	public enum Accion {
		ACTUALIZAR, CREAR
	};

}
