package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoTiposContacto;

/**
 * Este objeto representa el valor contenido del campo TipoContacto
 * el cual puede ser modificado por el usuario de consola.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class CampoContactoTipoContacto extends Campo {

	private Contacto contacto;
	private FachadaPersistente persistencia;

	public CampoContactoTipoContacto(Contacto contacto,
			FachadaPersistente persistencia) {
		super("TipoContacto");
		this.contacto = contacto;
		this.persistencia = persistencia;
	}

	@Override
	protected void tomaValor() {
		if (contacto.getTipoContacto() != null) {
			valor = contacto.getTipoContacto().getTipoContacto();
		} else {
			valor = "null";
		}
	}

	@Override
	protected void setValor() throws ReturnException {
		System.out.print(" pulse S para buscar o Intro para saltar.");
		if (teclado.getAceptar()) {
			ListadoTiposContacto listado = new ListadoTiposContacto(
					persistencia);
			listado.mostrar();
		}
		System.out.print("Elije una opción: ");
		contacto.setTipoContacto(persistencia.getTipoContacto(teclado.getInt()));
		tomaValor();
		System.out.println("Has elegido: " + valor);
	}

	public TipoContacto getValor() {
		return contacto.getTipoContacto();
	}
}
