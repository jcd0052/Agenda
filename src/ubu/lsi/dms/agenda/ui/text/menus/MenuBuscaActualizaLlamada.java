package ubu.lsi.dms.agenda.ui.text.menus;

import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.ReturnException;
import ubu.lsi.dms.agenda.ui.text.listas.FormularioLlamada;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoLlamadas;
import ubu.lsi.dms.agenda.ui.text.listas.Formulario.Accion;
import ubu.lsi.dms.agenda.ui.text.listas.ListadoContactos.Busqueda;

/**
 * Genera el menu para actualizar una llamada
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class MenuBuscaActualizaLlamada extends MenuListar {

	protected ListadoLlamadas listadoLlamadas;
	protected Llamada llamada;

	public MenuBuscaActualizaLlamada(FachadaPersistente persistencia) {
		super("Opción actualizar llamadas por contacto", persistencia);
	}

	@Override
	protected void buscar() throws ReturnException {
		//Pide elegir contacto
		ListadoContactos listadoContactos = new ListadoContactos(persistencia, Busqueda.COMPLETA);
		listadoContactos.mostrar();
		int idContacto = teclado.getInt("Introduce el idContacto: ");
		// Pide apellidos a buscar
		this.listadoLlamadas = new ListadoLlamadas(persistencia,
				persistencia.getContacto(idContacto));
		listadoLlamadas.mostrar();
		int idLlamada = teclado.getInt("Introduce el idLlamada: ");
		this.llamada = persistencia.getLlamada(idLlamada);
		if(llamada != null && llamada.getIdLlamada() > 0){
			actualizar();
		}
	}

	private void actualizar() {
		FormularioLlamada actualizarLlamada = new FormularioLlamada(
				persistencia, llamada, Accion.ACTUALIZAR);
		actualizarLlamada.mostrar();
	}

}
