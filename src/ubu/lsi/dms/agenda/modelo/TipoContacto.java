package ubu.lsi.dms.agenda.modelo;

import java.io.Serializable;

/**
 * Clase de entidad con la información de TipodeContacto
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class TipoContacto implements Serializable, Clonable<TipoContacto> {

	private static final long serialVersionUID = -7207281137632237204L;
	private int idTipoContacto;
	private String TipoContacto;

	public TipoContacto(int idTipoContacto, String tipoContacto) {
		super();
		this.idTipoContacto = idTipoContacto;
		TipoContacto = tipoContacto;
	}

	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	public String getTipoContacto() {
		return TipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		TipoContacto = tipoContacto;
	}

	public int getIdTipoContacto() {
		return idTipoContacto;
	}

	@Override
	public String toString() {
		return "TipoContacto [idTipoContacto=" + idTipoContacto
				+ ", TipoContacto=" + TipoContacto + "]";
	}

	@Override
	public boolean equals(Object o) {
		return (this.getIdTipoContacto() == ((TipoContacto) o)
				.getIdTipoContacto());
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
	
	@Override
	public TipoContacto copia() {
		TipoContacto copia = FabricaEntidades.newTipoContacto();
		copia.idTipoContacto = this.idTipoContacto;
		copia.TipoContacto = cpyStringOrNull(this.TipoContacto);
		
		return copia;
	}


}
