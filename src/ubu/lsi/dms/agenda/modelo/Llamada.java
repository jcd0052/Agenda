package ubu.lsi.dms.agenda.modelo;

import java.io.Serializable;

/**
 * Clase de entidad con la información de Llamada
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class Llamada implements Serializable, Clonable<Llamada> {

	private static final long serialVersionUID = -4620311382208372917L;
	private int idLlamada;
	private Contacto contacto;
	private String fechaLlamada;
	private String asunto, notas;

	public Llamada(int idLlamada, Contacto contacto, String fechaLlamada,
			String asunto, String notas) {
		super();
		this.idLlamada = idLlamada;
		this.contacto = contacto;
		this.fechaLlamada = fechaLlamada;
		this.asunto = asunto;
		this.notas = notas;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}

	public String getFechaLlamada() {
		return fechaLlamada;
	}

	public void setFechaLlamada(String fechaLlamada) {
		this.fechaLlamada = fechaLlamada;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public int getIdLlamada() {
		return idLlamada;
	}

	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", contacto=" + contacto
				+ ", fechaLlamada=" + fechaLlamada + ", asunto=" + asunto
				+ ", notas=" + notas + "]";
	}

	@Override
	public boolean equals(Object o) {
		return (this.getIdLlamada() == ((Llamada) o).getIdLlamada());
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
	private Contacto cpyContactoOrNull(Contacto origen) {
		if (origen != null) {
			return origen.copia();
		} else {
			return null;
		}
	}

	@Override
	public Llamada copia() {
		Llamada copia = FabricaEntidades.newLlamada();
		copia.idLlamada = this.idLlamada;
		copia.contacto = cpyContactoOrNull(this.contacto);
		copia.fechaLlamada = cpyStringOrNull(this.fechaLlamada);
		copia.asunto = cpyStringOrNull(this.asunto);
		copia.notas = cpyStringOrNull(this.notas);

		return copia;
	}

}
