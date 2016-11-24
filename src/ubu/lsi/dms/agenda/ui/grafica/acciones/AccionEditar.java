package ubu.lsi.dms.agenda.ui.grafica.acciones;

import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.entidad.EntidadGui;

public class AccionEditar implements Accion {
	
	@Override
	public void ejecutar(EntidadGui entidad) {
		entidad.editar();
	}

}
