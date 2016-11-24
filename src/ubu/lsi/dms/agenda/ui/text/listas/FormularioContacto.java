package ubu.lsi.dms.agenda.ui.text.listas;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.ui.text.campos.FabricaCampoContacto;

/**
 * Genera un formulario para ser rellenado con los campos correspondientes a la
 * entidad Contacto, facilitando el Contacto para ser actualizado o uno
 * vacio para ser creado.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FormularioContacto extends Formulario {
	protected FachadaPersistente persistencia;
	protected Contacto contacto;

	public FormularioContacto(FachadaPersistente persistencia,
			Contacto contacto, Accion accion) {
		super(new FabricaCampoContacto(persistencia, contacto)
				.crearCampoContactoIdContacto(), "Formulario Contacto", accion);
		FabricaCampoContacto fcontacto = new FabricaCampoContacto(persistencia,
				contacto);
		this.persistencia = persistencia;
		this.contacto = contacto;
		addCampo(fcontacto.crearCampoContactoNombre());
		addCampo(fcontacto.crearCampoContactoApellidos());
		addCampo(fcontacto.crearCampoContactoEstimado());
		addCampo(fcontacto.crearCampoContactoDireccion());
		addCampo(fcontacto.crearCampoContactoCiudad());
		addCampo(fcontacto.crearCampoContactoProvincia());
		addCampo(fcontacto.crearCampoContactoCodPostal());
		addCampo(fcontacto.crearCampoContactoRegion());
		addCampo(fcontacto.crearCampoContactoPais());
		addCampo(fcontacto.crearCampoContactoNomCompania());
		addCampo(fcontacto.crearCampoContactoCargo());
		addCampo(fcontacto.crearCampoContactoTelefonoTrabajo());
		addCampo(fcontacto.crearCampoContactoExtTrabajo());
		addCampo(fcontacto.crearCampoContactoTelMovil());
		addCampo(fcontacto.crearCampoContactoNumFax());
		addCampo(fcontacto.crearCampoContactoNomCorreo());
		addCampo(fcontacto.crearCampoContactoNotas());
		addCampo(fcontacto.crearCampoContactoTipoContacto());
	}
	
	@Override
	protected boolean crear() {
		return (persistencia.newContacto(contacto) > 0)?true:false;
	}

	@Override
	protected boolean actualizar() {
		return persistencia.updateContacto(contacto);
	}

}
