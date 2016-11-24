package ubu.lsi.dms.agenda.ui.text.campos;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

/**
 * Fábrica para crear los campos correspondientes a la entidad Contacto,
 * estos campos se utilizan en los formularios para mostrar el valor actual y
 * recoger el que el usuario introduzca por teclado.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FabricaCampoContacto {

	private Contacto contacto;
	private FachadaPersistente persistencia;
	
	public FabricaCampoContacto(FachadaPersistente persistencia, Contacto contacto){
		this.contacto = contacto;
		this.persistencia = persistencia;
	}
	

	public Campo crearCampoContactoIdContacto() {
		return new CampoContactoIdContacto(contacto);
	}

	public Campo crearCampoContactoNombre() {
		return new CampoContactoNombre(contacto);
	}
	
	public Campo crearCampoContactoApellidos() {
		return new CampoContactoApellidos(contacto);
	}


	public Campo crearCampoContactoEstimado() {
		return new CampoContactoEstimado(contacto);
	}


	public Campo crearCampoContactoDireccion() {
		return new CampoContactoDireccion(contacto);
	}


	public Campo crearCampoContactoCiudad() {
		return new CampoContactoCiudad(contacto);
	}


	public Campo crearCampoContactoProvincia() {
		return new CampoContactoProv(contacto);
	}


	public Campo crearCampoContactoCodPostal() {
		return new CampoContactoCodPostal(contacto);
	}


	public Campo crearCampoContactoRegion() {
		return new CampoContactoRegion(contacto);
	}

	
	public Campo crearCampoContactoPais() {
		return new CampoContactoPais(contacto);
	}

	
	public Campo crearCampoContactoNomCompania() {
		return new CampoContactoNomCompania(contacto);
	}

	
	public Campo crearCampoContactoCargo() {
		return new CampoContactoCargo(contacto);
	}


	public Campo crearCampoContactoTelefonoTrabajo() {
		return new CampoContactoTelefonoTrabajo(contacto);
	}


	public Campo crearCampoContactoExtTrabajo() {
		return new CampoContactoExtTrabajo(contacto);
	}


	public Campo crearCampoContactoTelMovil() {
		return new CampoContactoTelMovil(contacto);
	}


	public Campo crearCampoContactoNumFax() {
		return new CampoContactoNumFax(contacto);
	}


	public Campo crearCampoContactoNomCorreo() {
		return new CampoContactoNomCorreoElectronico(contacto);
	}


	public Campo crearCampoContactoTipoContacto() {
		return new CampoContactoTipoContacto(contacto, persistencia);
	}

	
	public Campo crearCampoContactoNotas() {
		return new CampoContactoNotas(contacto);
	}

}
