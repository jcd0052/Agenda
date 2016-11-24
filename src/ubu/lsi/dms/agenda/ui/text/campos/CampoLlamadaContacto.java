package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos.Busqueda;

/**
 * Este objeto representa el valor contenido del campo Contacto
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoLlamadaContacto extends Campo {

	private Contacto contacto;
	private FachadaPersistente persistencia;
	private Llamada llamada;

	public CampoLlamadaContacto(Llamada llamada, FachadaPersistente persistencia) {
		super("Contacto");
		this.llamada = llamada;
		this.persistencia = persistencia;
	}

	@Override
	protected void tomaValor() {
		if (llamada.getContacto() != null) {
			valor = llamada.getContacto().getNombre() + " "
					+ llamada.getContacto().getApellidos();
		} else {
			valor = "null";
		}
	}

	@Override
	protected void setValor() throws ReturnException {
		System.out.print(" pulse S para buscar o Intro para saltar.");
		if (teclado.getAceptar()) {
			ListadoContactos listado = new ListadoContactos(persistencia,
					Busqueda.COMPLETA);
			listado.mostrar();
		}
		System.out.print("Elije una opción: ");
		llamada.setContacto(persistencia.getContacto(teclado.getInt()));
		tomaValor();
		System.out.println("Has elegido: " + valor);
	}

	public TipoContacto getValor() {
		return contacto.getTipoContacto();
	}
}
