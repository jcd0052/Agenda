/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Implementación de la persistencia con Objetos del subsistema Modelo
 * Serializados
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class FachadaBin implements FachadaPersistente, Serializable {

	private static final long serialVersionUID = 6914968751978575929L;
	private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	private ArrayList<TipoContacto> tiposcontacto = new ArrayList<TipoContacto>();
	private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
	private int idContacto;
	private int idTipoContacto;
	private int idLlamada;
	private File fagenda;

	public FachadaBin(File fagenda) {
		this.fagenda = fagenda;
		this.idContacto = 0;
		this.idTipoContacto = 0;
		this.idLlamada = 0;
	}

	@Override
	public Contacto getContacto(int idContacto) {
		Contacto co = getContactoBin(idContacto);
		return (co != null) ? co.copia() : null;
	}

	/**
	 * Devuelve referencia al Contacto que hay en el fichero
	 * 
	 * @param idContacto
	 * @return
	 */
	private Contacto getContactoBin(int idContacto) {
		for (Contacto e : contactos) {
			if (e.getIdContacto() == idContacto) {
				return e;
			}
		}
		return null;
	}

	@Override
	public Llamada getLlamada(int idLlamada) {
		Llamada ll = getLlamadaBin(idLlamada);
		return (ll != null) ? ll.copia() : null;
	}

	/**
	 * Devuelve una referencia a la Llamada que hay en el fichero
	 * 
	 * @param idLlamada
	 * @return
	 */
	private Llamada getLlamadaBin(int idLlamada) {
		for (Llamada e : llamadas) {
			if (e.getIdLlamada() == idLlamada) {
				return e;
			}
		}
		return null;
	}

	@Override
	public TipoContacto getTipoContacto(int idTipoContacto) {
		TipoContacto tc = getTipoContactoBin(idTipoContacto);
		return (tc != null) ? tc.copia() : null;
	}

	/**
	 * Devuelve una referencia al TipoContacto que hay en el fichero
	 * 
	 * @param idTipoContacto
	 * @return
	 */
	private TipoContacto getTipoContactoBin(int idTipoContacto) {
		for (TipoContacto e : tiposcontacto) {
			if (e.getIdTipoContacto() == idTipoContacto) {
				return e;
			}
		}
		return null;
	}

	@Override
	public int newContacto(Contacto contacto) {
		Contacto contactoBin = contacto.copia();
		if (constrainsContacto(contactoBin)) {
			contactoBin.setIdContacto(++idContacto);
			contactos.add(contactoBin);
			return idContacto;
		} else {
			return 0;
		}
	}

	@Override
	public int newLlamada(Llamada llamada) {
		Llamada llamadaBin = llamada.copia();
		if (constrainsLlamada(llamadaBin)) {
			llamadaBin.setIdLlamada(++idLlamada);
			llamadas.add(llamadaBin);
			return idLlamada;
		} else {
			return 0;
		}
	}

	@Override
	public int newTipoContacto(TipoContacto tipoContacto) {
		TipoContacto tipoContactoBin = tipoContacto.copia();
		if (constrainsTipoContacto(tipoContactoBin)) {
			tipoContactoBin.setIdTipoContacto(++idTipoContacto);
			tiposcontacto.add(tipoContactoBin);
			return idTipoContacto;
		} else {
			return 0;
		}
	}

	@Override
	public boolean updateContacto(Contacto contacto) {
		Contacto contactoBin = contacto.copia();
		if (constrainsContacto(contactoBin)) {
			int index = contactos.indexOf(contactoBin);
			if (index > -1 && contactos.set(index, contactoBin) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateLlamada(Llamada llamada) {
		Llamada llamadaBin = llamada.copia();
		if (constrainsLlamada(llamadaBin)) {
			int index = llamadas.indexOf(llamadaBin);
			if (index > -1 && llamadas.set(index, llamadaBin) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateTipoContacto(TipoContacto tipoContacto) {
		TipoContacto tipoContactoBin = tipoContacto.copia();
		if (constrainsTipoContacto(tipoContactoBin)) {
			int index = tiposcontacto.indexOf(tipoContactoBin);
			if (index > -1 && tiposcontacto.set(index, tipoContactoBin) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Contacto> getContactos(String apellidos) {
		List<Contacto> contacts = new ArrayList<Contacto>();
		for (Contacto e : contactos) {
			if (apellidos.equals(e.getApellidos())) {
				contacts.add(e.copia());
			}
		}
		return (contacts.size() == 0) ? null : contacts;
	}

	@Override
	public List<Contacto> getContactos() {
		List<Contacto> contacts = new ArrayList<Contacto>();
		for (Contacto e : contactos) {
			contacts.add(e.copia());
		}
		return (contacts.size() == 0) ? null : contacts;
	}

	@Override
	public List<Llamada> getLlamadas(int idContacto) {
		List<Llamada> llamads = new ArrayList<Llamada>();
		for (Llamada e : llamadas) {
			if (e.getContacto() != null
					&& e.getContacto().getIdContacto() == idContacto) {
				llamads.add(e.copia());
			}
		}
		return (llamads.size() == 0) ? null : llamads;
	}

	@Override
	public List<TipoContacto> getTiposContacto() {
		List<TipoContacto> tiposcontact = new ArrayList<TipoContacto>();
		for (TipoContacto e : tiposcontacto) {
			tiposcontact.add(e.copia());
		}
		return (tiposcontact.size() == 0) ? null : tiposcontact;
	}

	/**
	 * Comprueba las restricciones de Contacto
	 * 
	 * @param contacto
	 * @return true si ha pasado las restricciones
	 */
	private boolean constrainsContacto(Contacto contacto) {
		boolean resultado = true;

		// Comprueba foreing keys y asocia
		if (resultado && contacto.getTipoContacto() != null) {
			TipoContacto aux = getTipoContactoBin(contacto.getTipoContacto()
					.getIdTipoContacto());
			if (aux != null) {
				contacto.setTipoContacto(aux);
			} else {
				resultado = false;
			}
		}

		return resultado;
	}

	/**
	 * Comprueba las restricciones de Llamada
	 * 
	 * @param llamada
	 * @return true si ha pasado las restricciones
	 */
	private boolean constrainsLlamada(Llamada llamada) {
		boolean resultado = true;
		// Comprueba campos no nulos
		resultado &= (llamada.getContacto() != null);
		resultado &= notNull(llamada.getFechaLlamada());
		resultado &= notNull(llamada.getAsunto());

		// Comprueba el formato de la fecha
		try {
			Timestamp.valueOf(llamada.getFechaLlamada());
		} catch (IllegalArgumentException e) {
			resultado = false;
		}
		
		
		// Comprueba foreing keys y asocia
		if (resultado) {
			Contacto aux = getContactoBin(llamada.getContacto().getIdContacto());
			if (aux != null) {
				llamada.setContacto(aux);
			} else {
				resultado = false;
			}
		}

		return resultado;
	}

	/**
	 * Comprueba las restricciones de TipoContacto
	 * 
	 * @param tipoContacto
	 * @return true si ha pasado las restricciones
	 */
	private boolean constrainsTipoContacto(TipoContacto tipoContacto) {
		boolean resultado = true;
		resultado &= notNull(tipoContacto.getTipoContacto());
		return resultado;
	}

	/**
	 * Comprueba restricción de not null en un campo de texto.
	 * 
	 * @param texto
	 * @return true si ha pasado la restriccion
	 */
	private boolean notNull(String texto) {
		return (texto != null && !texto.equals(""));
	}

	@Override
	public void close() {
		File carpeta = new File(fagenda.getParent());
		try {
			if (!carpeta.exists()) {
				carpeta.mkdir();
			}
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fagenda));
			out.writeObject(this);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				this.finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}

}
