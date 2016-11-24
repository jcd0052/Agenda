package ubu.lsi.dms.agenda.modelo;

import java.io.Serializable;

/**
 * Clase de entidad con la información de Contactos
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class Contacto implements Serializable, Clonable<Contacto> {

	private static final long serialVersionUID = -560860794293434369L;
	private int idContacto;
	private String nombre, apellidos, estimado, direccion, ciudad, prov,
			codPostal, region, pais, nombreCompania, cargo, telefonoTrabajo,
			extensionTrabajo, telefonoMovil, numFax, nomCorreoElectronico,
			notas;

	private TipoContacto tipoContacto;

	public Contacto(int idContacto, String nombre, String apellidos,
			String estimado, String direccion, String ciudad, String prov,
			String codPostal, String region, String pais,
			String nombreCompania, String cargo, String telefonoTrabajo,
			String extensionTrabajo, String telefonoMovil, String numFax,
			String nomCorreoElectronico, String notas, TipoContacto tipoContacto) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estimado = estimado;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.prov = prov;
		this.codPostal = codPostal;
		this.region = region;
		this.pais = pais;
		this.nombreCompania = nombreCompania;
		this.cargo = cargo;
		this.telefonoTrabajo = telefonoTrabajo;
		this.extensionTrabajo = extensionTrabajo;
		this.telefonoMovil = telefonoMovil;
		this.numFax = numFax;
		this.nomCorreoElectronico = nomCorreoElectronico;
		this.notas = notas;
		this.tipoContacto = tipoContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEstimado() {
		return estimado;
	}

	public void setEstimado(String estimado) {
		this.estimado = estimado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	public String getExtensionTrabajo() {
		return extensionTrabajo;
	}

	public void setExtensionTrabajo(String extensionTrabajo) {
		this.extensionTrabajo = extensionTrabajo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getNumFax() {
		return numFax;
	}

	public void setNumFax(String numFax) {
		this.numFax = numFax;
	}

	public String getNomCorreoElectronico() {
		return nomCorreoElectronico;
	}

	public void setNomCorreoElectronico(String nomCorreoElectronico) {
		this.nomCorreoElectronico = nomCorreoElectronico;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public int getIdContacto() {
		return idContacto;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", estimado=" + estimado
				+ ", direccion=" + direccion + ", ciudad=" + ciudad + ", prov="
				+ prov + ", codPostal=" + codPostal + ", region=" + region
				+ ", pais=" + pais + ", nombreCompania=" + nombreCompania
				+ ", cargo=" + cargo + ", telefonoTrabajo=" + telefonoTrabajo
				+ ", extensionTrabajo=" + extensionTrabajo + ", telefonoMovil="
				+ telefonoMovil + ", numFax=" + numFax
				+ ", nomCorreoElectronico=" + nomCorreoElectronico + ", notas="
				+ notas + ", tipoContacto=" + tipoContacto + "]";
	}

	@Override
	public boolean equals(Object o) {
		return (this.getIdContacto() == ((Contacto) o).getIdContacto());
	}

	/**
	 * Devuelve una copia del miembro String o nulo
	 * 
	 * @param origen
	 *            String del que se desea obtener copia
	 * @return copia del origen o nulo
	 */
	private String cpyStringOrNull(String origen) {
		if (origen != null) {
			return new String(origen);
		} else {
			return null;
		}
	}

	/**
	 * Devuelve una copia del origen o nulo si es nulo el origen
	 * 
	 * @param origen
	 * @return
	 */
	private TipoContacto cpyTipoContactoOrNull(TipoContacto origen) {
		if (origen != null) {
			return origen.copia();
		} else {
			return null;
		}
	}

	@Override
	public Contacto copia() {
		Contacto copia = FabricaEntidades.newContacto();
		copia.idContacto = this.idContacto;
		copia.nombre = cpyStringOrNull(this.nombre);
		copia.apellidos = cpyStringOrNull(this.apellidos);
		copia.estimado = cpyStringOrNull(this.estimado);
		copia.direccion = cpyStringOrNull(this.direccion);
		copia.ciudad = cpyStringOrNull(this.ciudad);
		copia.prov = cpyStringOrNull(this.prov);
		copia.codPostal = cpyStringOrNull(this.codPostal);
		copia.region = cpyStringOrNull(this.region);
		copia.pais = cpyStringOrNull(this.pais);
		copia.nombreCompania = cpyStringOrNull(this.nombreCompania);
		copia.cargo = cpyStringOrNull(this.cargo);
		copia.telefonoTrabajo = cpyStringOrNull(this.telefonoTrabajo);
		copia.extensionTrabajo = cpyStringOrNull(this.extensionTrabajo);
		copia.telefonoMovil = cpyStringOrNull(this.telefonoMovil);
		copia.numFax = cpyStringOrNull(this.numFax);
		copia.nomCorreoElectronico = cpyStringOrNull(this.nomCorreoElectronico);
		copia.tipoContacto = cpyTipoContactoOrNull(this.tipoContacto);
		copia.notas = cpyStringOrNull(this.notas);

		return copia;
	}

}
