/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.hsqldb.jdbc.JDBCDataSource;

import ubu.lsi.dms.agenda.Agenda;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Clase que implementa los métodos de acceso a un SGBD HSQL
 * 
 * @author José Ramón Cuevas Diez
 */
public class FachadaBD implements FachadaPersistente {
	/**
	 * Conexion con el SGBD
	 */
	private Connection con = null;

	/**
	 * Servidor donde está funcionado el SGBD.
	 */
	private static final String servidor = "localhost";

	/**
	 * Usuario de la base de datos.
	 */
	private static final String usuario = "SA";

	/**
	 * Contraseña.
	 */
	private static final String password = "";

	/**
	 * Sistema gestor de base de datos.
	 */
	private static final String SGBD = "hsqldb:hsql";

	/**
	 * Base de datos sobre la que trabajamos.
	 */
	private static final String baseDeDatos = "Agenda";

	/**
	 * Formato de salida de la fecha
	 */
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * Constructor de la clase.
	 */
	public FachadaBD() {
		try {
			this.con = getConnectionWithDataSource();
		} catch (SQLException e) {
			Agenda.mostrarAyuda();
			System.exit(-1);
		}
	}

	/**
	 * Obtiene una conexión a la base de datos utilizando un DataSource. En este
	 * caso un DataSource no gestionado por servidor, sino directamente
	 * instanciado.
	 * 
	 * @return conexión
	 * @throws SQLException
	 *             error en acceso a la base de datos
	 */
	private Connection getConnectionWithDataSource() throws SQLException {
		Connection conn = null;
		// Data Source básico para Hsqldb
		JDBCDataSource ds = new JDBCDataSource();
		// Establecer parámetros
		// ds.setServerName(servidor);
		// ds.setPortNumber(Integer.parseInt(puerto));
		ds.setDatabaseName("jdbc:" + SGBD + "://" + servidor + "/"
				+ baseDeDatos);
		ds.setUser(usuario);
		ds.setPassword(password);
		// Obtener conexión
		conn = ds.getConnection();
		return conn;
	}

	@Override
	public Contacto getContacto(int idContacto) {
		Contacto contacto = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM CONTACTOS" + " WHERE idContacto=?";
		try {
			// Realizamos la consulta
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idContacto);
			ResultSet rs = stmt.executeQuery();

			// Almacenando resultado
			while (rs.next()) {
				contacto = new Contacto(idContacto, rs.getString("Nombre"),
						rs.getString("Apellidos"), rs.getString("Estimado"),
						rs.getString("Direccion"), rs.getString("Ciudad"),
						rs.getString("Prov"), rs.getString("CodPostal"),
						rs.getString("Region"), rs.getString("Pais"),
						rs.getString("NombreCompania"), rs.getString("Cargo"),
						rs.getString("TelefonoTrabajo"),
						rs.getString("ExtensionTrabajo"),
						rs.getString("TelefonoMovil"), rs.getString("NumFax"),
						rs.getString("NomCorreoElectronico"),
						rs.getString("Notas"),
						getTipoContacto(rs.getInt("IdTipoContacto")));
			}
			rs.close();

		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
		return contacto;
	}

	@Override
	public Llamada getLlamada(int idLlamada) {
		Llamada llamada = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM LLAMADAS WHERE idLlamada=?";
		try {
			// Realizamos consulta
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idLlamada);
			ResultSet rs = stmt.executeQuery();

			// Almacenando resultado
			while (rs.next()) {
				llamada = new Llamada(rs.getInt("IdLlamada"),
						getContacto(rs.getInt("IdContacto")),
						DATE_FORMAT.format(rs.getTimestamp("FechaLlamada")),
						rs.getString("Asunto"), rs.getString("Notas"));
			}
			rs.close();

		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
		return llamada;
	}

	@Override
	public TipoContacto getTipoContacto(int idTipoContacto) {
		TipoContacto tipoContacto = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM TIPOSDECONTACTO WHERE idTipoContacto=?";
		try {
			// Realizamos consulta
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idTipoContacto);
			ResultSet rs = stmt.executeQuery();

			// Almacenando resultado
			while (rs.next()) {
				tipoContacto = new TipoContacto(idTipoContacto,
						rs.getString("TipoContacto"));
			}
			rs.close();

		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
		return tipoContacto;
	}

	@Override
	public int newContacto(Contacto contacto) {
		PreparedStatement stmt = null;
		int resultado;
		String SQL = "INSERT INTO CONTACTOS ( \"NOMBRE\",  \"APELLIDOS\", \"ESTIMADO\", \"DIRECCION\", \"CIUDAD\", \"PROV\", \"CODPOSTAL\", \"REGION\", \"PAIS\", \"NOMBRECOMPANIA\", \"CARGO\", \"TELEFONOTRABAJO\", \"EXTENSIONTRABAJO\", \"TELEFONOMOVIL\", \"NUMFAX\", \"NOMCORREOELECTRONICO\", \"IDTIPOCONTACTO\", \"NOTAS\") VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String SQL1 = "SELECT * FROM CONTACTOS WHERE NOMBRE = ? AND APELLIDOS = ?";
		try {
			// Insertamos datos
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, contacto.getNombre());
			stmt.setString(2, contacto.getApellidos());
			stmt.setString(3, contacto.getEstimado());
			stmt.setString(4, contacto.getDireccion());
			stmt.setString(5, contacto.getCiudad());
			stmt.setString(6, contacto.getProv());
			stmt.setString(7, contacto.getCodPostal());
			stmt.setString(8, contacto.getRegion());
			stmt.setString(9, contacto.getPais());
			stmt.setString(10, contacto.getNombreCompania());
			stmt.setString(11, contacto.getCargo());
			stmt.setString(12, contacto.getTelefonoTrabajo());
			stmt.setString(13, contacto.getExtensionTrabajo());
			stmt.setString(14, contacto.getTelefonoMovil());
			stmt.setString(15, contacto.getNumFax());
			stmt.setString(16, contacto.getNomCorreoElectronico());
			if (contacto.getTipoContacto() == null){
				stmt.setNull(17, Types.INTEGER);
			}else{
				stmt.setInt(17, contacto.getTipoContacto().getIdTipoContacto());
			}
			stmt.setString(18, contacto.getNotas());
			resultado = stmt.executeUpdate();
			stmt.close();

			// Conseguimos el id
			stmt = con.prepareStatement(SQL1);
			stmt.setString(1, contacto.getNombre());
			stmt.setString(2, contacto.getApellidos());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resultado = rs.getInt("IdContacto");
			}
			rs.close();
		} catch (SQLException e) {
			// e.printStackTrace();
			resultado = 0;
		} finally {
			close(stmt);
		}
		return resultado;
	}

	@Override
	public int newLlamada(Llamada llamada) {
		PreparedStatement stmt = null;
		int resultado;
		String SQL = "INSERT INTO LLAMADAS ( \"IDCONTACTO\",  \"FECHALLAMADA\", \"ASUNTO\", \"NOTAS\") VALUES ( ? , ?, ?, ?)";
		String SQL1 = "SELECT * FROM LLAMADAS WHERE IDCONTACTO = ?";
		try {
			// Insertamos datos
			stmt = con.prepareStatement(SQL);
			if(llamada.getContacto() == null){
				stmt.setNull(1, Types.INTEGER);
			}else{
				stmt.setInt(1, llamada.getContacto().getIdContacto());
			}
			stmt.setTimestamp(2, Timestamp.valueOf(llamada.getFechaLlamada()));
			stmt.setString(3, llamada.getAsunto());
			stmt.setString(4, llamada.getNotas());
			resultado = stmt.executeUpdate();
			stmt.close();

			// Obtenemos id
			stmt = con.prepareStatement(SQL1);
			stmt.setInt(1, llamada.getContacto().getIdContacto());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resultado = rs.getInt("IdLlamada");
			}
			rs.close();
		} catch (SQLException | IllegalArgumentException e) {
			// e.printStackTrace();
			resultado = 0;
		} finally {
			close(stmt);
		}
		return resultado;
	}

	@Override
	public int newTipoContacto(TipoContacto tipoContacto) {
		PreparedStatement stmt = null;
		int resultado;
		String SQL = "INSERT INTO TIPOSDECONTACTO ( \"TIPOCONTACTO\" ) VALUES ( ? )";
		String SQL1 = "SELECT * FROM TIPOSDECONTACTO WHERE TIPOCONTACTO = ?";
		try {
			// Insertamos datos
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, tipoContacto.getTipoContacto());
			resultado = stmt.executeUpdate();

			// Obtenemos id
			stmt.close();
			stmt = con.prepareStatement(SQL1);
			stmt.setString(1, tipoContacto.getTipoContacto());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resultado = rs.getInt("IdTipoContacto");
			}
			rs.close();
		} catch (SQLException e) {
			// e.printStackTrace();
			resultado = 0;
		} finally {
			close(stmt);
		}
		return resultado;
	}

	@Override
	public boolean updateContacto(Contacto contacto) {
		PreparedStatement stmt = null;
		String sql = "UPDATE CONTACTOS SET NOMBRE = ?, APELLIDOS = ?, ESTIMADO = ?, DIRECCION = ?, CIUDAD = ?, PROV = ?, CODPOSTAL = ?, REGION = ?, PAIS = ?, NOMBRECOMPANIA = ?, CARGO = ?, TELEFONOTRABAJO = ?, EXTENSIONTRABAJO = ?, TELEFONOMOVIL = ?, NUMFAX = ?, NOMCORREOELECTRONICO = ?, IDTIPOCONTACTO = ?, NOTAS = ? WHERE IDCONTACTO = ?";
		int resultado;
		try {
			// Realizado actualizacion
			stmt = con.prepareStatement(sql);
			stmt.setString(1, contacto.getNombre());
			stmt.setString(2, contacto.getApellidos());
			stmt.setString(3, contacto.getEstimado());
			stmt.setString(4, contacto.getDireccion());
			stmt.setString(5, contacto.getCiudad());
			stmt.setString(6, contacto.getProv());
			stmt.setString(7, contacto.getCodPostal());
			stmt.setString(8, contacto.getRegion());
			stmt.setString(9, contacto.getPais());
			stmt.setString(10, contacto.getNombreCompania());
			stmt.setString(11, contacto.getCargo());
			stmt.setString(12, contacto.getTelefonoTrabajo());
			stmt.setString(13, contacto.getExtensionTrabajo());
			stmt.setString(14, contacto.getTelefonoMovil());
			stmt.setString(15, contacto.getNumFax());
			stmt.setString(16, contacto.getNomCorreoElectronico());
			if (contacto.getTipoContacto() != null) {
				stmt.setInt(17, contacto.getTipoContacto().getIdTipoContacto());
			} else {
				stmt.setInt(17, 0);
			}
			stmt.setString(18, contacto.getNotas());
			stmt.setInt(19, contacto.getIdContacto());
			resultado = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			resultado = 0;
		} finally {
			close(stmt);
		}
		return (resultado > 0) ? true : false;
	}

	@Override
	public boolean updateLlamada(Llamada llamada) {
		PreparedStatement stmt = null;
		String sql = "UPDATE LLAMADAS SET IDCONTACTO = ?, FECHALLAMADA = ?, ASUNTO = ?, NOTAS = ? WHERE IDLLAMADA = ?";
		int resultado;
		try {
			// Realizado actualizacion
			stmt = con.prepareStatement(sql);
			if(llamada.getContacto() == null){
				stmt.setNull(1, Types.INTEGER);
			}else{
				stmt.setInt(1, llamada.getContacto().getIdContacto());
			}
			stmt.setTimestamp(2, Timestamp.valueOf(llamada.getFechaLlamada()));
			stmt.setString(3, llamada.getAsunto());
			stmt.setString(4, llamada.getNotas());
			stmt.setInt(5, llamada.getIdLlamada());
			resultado = stmt.executeUpdate();
		} catch (SQLException | IllegalArgumentException e) {
			// e.printStackTrace();
			resultado = 0;
		} finally {
			close(stmt);
		}
		return (resultado > 0) ? true : false;
	}

	@Override
	public boolean updateTipoContacto(TipoContacto tipoContacto) {
		PreparedStatement stmt = null;
		String sql = "UPDATE TIPOSDECONTACTO SET TIPOCONTACTO = ? WHERE IDTIPOCONTACTO = ?";
		int resultado;
		try {
			// Realizado actualizacion
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tipoContacto.getTipoContacto());
			stmt.setInt(2, tipoContacto.getIdTipoContacto());
			resultado = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			resultado = 0;
		} finally {
			close(stmt);
		}
		return (resultado > 0) ? true : false;
	}

	@Override
	public List<Contacto> getContactos(String apellidos) {
		List<Contacto> contactos = new LinkedList<Contacto>();
		Contacto contacto = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM CONTACTOS" + " WHERE Apellidos=?";
		try {
			// Realizado consulta
			stmt = con.prepareStatement(sql);
			stmt.setString(1, apellidos);
			ResultSet rs = stmt.executeQuery();

			// Almacenando resultados
			while (rs.next()) {
				contacto = new Contacto(rs.getInt("IdContacto"),
						rs.getString("Nombre"), rs.getString("Apellidos"),
						rs.getString("Estimado"), rs.getString("Direccion"),
						rs.getString("Ciudad"), rs.getString("Prov"),
						rs.getString("CodPostal"), rs.getString("Region"),
						rs.getString("Pais"), rs.getString("NombreCompania"),
						rs.getString("Cargo"), rs.getString("TelefonoTrabajo"),
						rs.getString("ExtensionTrabajo"),
						rs.getString("TelefonoMovil"), rs.getString("NumFax"),
						rs.getString("NomCorreoElectronico"),
						rs.getString("Notas"),
						getTipoContacto(rs.getInt("IdTipoContacto")));
				contactos.add(contacto);
			}
			rs.close();

		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
		return contactos;
	}

	@Override
	public List<Contacto> getContactos() {
		List<Contacto> contactos = new LinkedList<Contacto>();
		Contacto contacto = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM CONTACTOS";
		try {
			// Realizado consulta
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// Almacenando resultados
			while (rs.next()) {
				contacto = new Contacto(rs.getInt("IdContacto"),
						rs.getString("Nombre"), rs.getString("Apellidos"),
						rs.getString("Estimado"), rs.getString("Direccion"),
						rs.getString("Ciudad"), rs.getString("Prov"),
						rs.getString("CodPostal"), rs.getString("Region"),
						rs.getString("Pais"), rs.getString("NombreCompania"),
						rs.getString("Cargo"), rs.getString("TelefonoTrabajo"),
						rs.getString("ExtensionTrabajo"),
						rs.getString("TelefonoMovil"), rs.getString("NumFax"),
						rs.getString("NomCorreoElectronico"),
						rs.getString("Notas"),
						getTipoContacto(rs.getInt("IdTipoContacto")));
				contactos.add(contacto);
			}
			rs.close();

		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
		return contactos;
	}

	@Override
	public List<Llamada> getLlamadas(int idContacto) {
		List<Llamada> llamadas = new LinkedList<Llamada>();
		Llamada llamada = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM LLAMADAS" + " WHERE idContacto=?";
		try {
			// Realizado consulta
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idContacto);
			ResultSet rs = stmt.executeQuery();

			// Almacenando resultados
			while (rs.next()) {
				llamada = new Llamada(rs.getInt("IdLlamada"),
						getContacto(idContacto), DATE_FORMAT.format(rs
								.getTimestamp("FechaLlamada")),
						rs.getString("Asunto"), rs.getString("Notas"));
				llamadas.add(llamada);
			}
			rs.close();

		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
		return llamadas;
	}

	@Override
	public List<TipoContacto> getTiposContacto() {
		List<TipoContacto> tiposContacto = new LinkedList<TipoContacto>();
		TipoContacto tipoContacto = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM TIPOSDECONTACTO";
		try {
			// Realiza la consulta
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// Almacenando resultados
			while (rs.next()) {
				tipoContacto = new TipoContacto(rs.getInt("IdTipoContacto"),
						rs.getString("TipoContacto"));
				tiposContacto.add(tipoContacto);
			}
			rs.close();

		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
		return tiposContacto;
	}

	@Override
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			// e.printStackTrace();
		} finally {
			try {
				this.finalize();
			} catch (Throwable e) {
				// TODO Bloque catch generado automáticamente
				// e.printStackTrace();
			}
		}

	}

	/**
	 * Cierre de la sentencia
	 * 
	 * @param stmt
	 */
	private void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			} // Cierre del recurso
		}
	}

}
