package ubu.lsi.dms.test.agenda.persistencia;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;
import ubu.lsi.dms.agenda.persistencia.Persistencia;

/**
 * Clase para probar el funcionamiento de las clases de persistencia.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class TestPersistencia extends TestCase {
	private static String tipoPersistencia;
	private static FachadaPersistente persistencia;
	private static int idtipocontacto1;
	private static int idcontacto1;
	private static int idllamada1;
	private static int idtipocontacto2;
	private static int idcontacto2;
	private static int idllamada2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// El tipo de persistencia se indica como argumento al llamar al test
		tipoPersistencia = args[0];

		junit.textui.TestRunner.run(suite());
	}

	/**
	 * Devolución de instancia de test
	 * 
	 * @return
	 */
	public static Test suite() {
		return new AlphabeticMethodSorterTestSuite(TestPersistencia.class);
	}

	public TestPersistencia(String name) {
		super(name);
	}

	/**
	 * Test de creación de persistencia
	 */
	public void test00CreaPersistencia() {
		Persistencia.setTipo(tipoPersistencia);
		persistencia = Persistencia.getPersistencia();
		assertNotNull(persistencia);
	}

	/**
	 * Test de insercion de tipo contacto
	 */
	public void test01InsertaTipoContacto() {
		TipoContacto tipoIn1 = new TipoContacto(0, "Familia");
		TipoContacto tipoIn2 = new TipoContacto(0, "Amigos");
		TipoContacto tipoOut1, tipoOut2;
		idtipocontacto1 = persistencia.newTipoContacto(tipoIn1);
		idtipocontacto2 = persistencia.newTipoContacto(tipoIn2);
		tipoOut1 = persistencia.getTipoContacto(idtipocontacto1);
		tipoOut2 = persistencia.getTipoContacto(idtipocontacto2);
		// Comprobaciones
		assertEquals(tipoIn1.getTipoContacto(), tipoOut1.getTipoContacto());
		assertEquals(tipoIn2.getTipoContacto(), tipoOut2.getTipoContacto());
		assertTrue("Comprobación de que los ids son correlativos",
				(idtipocontacto2 - idtipocontacto1) == 1);
	}

	/**
	 * Test de insercion de contacto
	 */
	public void test02InsertaContacto() {
		Contacto contactoIn1 = new Contacto(0, "Jose", "Cuevas", null, null,
				null, null, null, null, null, null, null, null, null, null,
				null, null, null, persistencia.getTipoContacto(idtipocontacto1));
		Contacto contactoIn2 = new Contacto(0, "Jose", "Cuevas Diez", "Sr.",
				"Barrio Juan", "Burgos", "Burgos", "09007", "Castilla y León",
				"España", "MAGSA", "Jefe de Sección", "947404200", "232",
				"686491596", "947404201", "jrcuevas@miquel.es",
				"Nada que poner", persistencia.getTipoContacto(idtipocontacto1));
		Contacto contactoOut1, contactoOut2;
		idcontacto1 = persistencia.newContacto(contactoIn1);
		idcontacto2 = persistencia.newContacto(contactoIn2);
		// introduce el id asignado por la persistencia
		contactoIn1.setIdContacto(idcontacto1);
		contactoIn2.setIdContacto(idcontacto2);
		contactoOut1 = persistencia.getContacto(idcontacto1);
		contactoOut2 = persistencia.getContacto(idcontacto2);
		// Comprobaciones
		assertEquals(contactoIn1.toString(), contactoOut1.toString());
		assertEquals(contactoIn2.toString(), contactoOut2.toString());
		assertTrue("Comprobación de que los ids son correlativos",
				(idcontacto2 - idcontacto1) == 1);
	}

	/**
	 * Test de insercion de llamada
	 */
	public void test03InsertaLlamada() {
		Llamada llamadaIn1 = new Llamada(0,
				persistencia.getContacto(idcontacto1), "2015-12-23 12:00:01",
				"Prueba1", "Nota de prueba1");
		Llamada llamadaIn2 = new Llamada(0,
				persistencia.getContacto(idcontacto1), "2015-12-23 12:02:01",
				"Prueba", "Nota de prueba");
		Llamada llamadaOut1, llamadaOut2;
		idllamada1 = persistencia.newLlamada(llamadaIn1);
		idllamada2 = persistencia.newLlamada(llamadaIn2);
		// introduce el id asignado por la persistencia
		llamadaIn1.setIdLlamada(idllamada1);
		llamadaIn2.setIdLlamada(idllamada2);
		llamadaOut1 = persistencia.getLlamada(idllamada1);
		llamadaOut2 = persistencia.getLlamada(idllamada2);
		// Comprobaciones
		assertEquals(llamadaIn1.toString(), llamadaOut1.toString());
		assertEquals(llamadaIn2.toString(), llamadaOut2.toString());
		assertTrue("Comprobación de que los ids son correlativos",
				(idllamada2 - idllamada1) == 1);
	}

	/**
	 * Test de actualizacion de tipo contacto
	 */
	public void test04ActualizaTipoContacto() {
		TipoContacto tipocontacto1 = persistencia
				.getTipoContacto(idtipocontacto1);
		tipocontacto1.setTipoContacto("Familiares");
		assertTrue("Realiza la actualización",
				persistencia.updateTipoContacto(tipocontacto1));
		assertEquals(tipocontacto1.toString(),
				persistencia.getTipoContacto(idtipocontacto1).toString());
	}

	/**
	 * Test de actualizacion de contacto
	 */
	public void test05ActualizaContacto() {
		Contacto contacto1 = persistencia.getContacto(idcontacto1);
		contacto1
				.setTipoContacto(persistencia.getTipoContacto(idtipocontacto2));
		assertTrue("Realiza la actualización",
				persistencia.updateContacto(contacto1));
		assertEquals(contacto1.toString(), persistencia
				.getContacto(idcontacto1).toString());
	}

	/**
	 * Test de actualizacion de llamada
	 */
	public void test06ActualizaLlamada() {
		Llamada llamada1 = persistencia.getLlamada(idllamada1);
		llamada1.setContacto(persistencia.getContacto(idcontacto2));
		assertTrue("Realiza la actualización",
				persistencia.updateLlamada(llamada1));
		assertEquals(llamada1.toString(), persistencia.getLlamada(idllamada1)
				.toString());
	}

	/**
	 * Test de consulta de contacto
	 */
	public void test07ConsultaContactos() {
		List<Contacto> contactos = persistencia.getContactos("Cuevas");
		for (Contacto e : contactos) {
			assertEquals(e.getApellidos(), "Cuevas");
		}
	}

	/**
	 * Test de consulta de llamadas
	 */
	public void test08ConsultaLlamadas() {
		List<Llamada> llamadas = persistencia.getLlamadas(idcontacto1);
		for (Llamada e : llamadas) {
			assertEquals(e.getContacto(), persistencia.getContacto(idcontacto1));
		}
	}

	/**
	 * Test de consulta de tipo contacto
	 */
	public void test09ConsultaTiposContacto() {
		List<TipoContacto> tiposcontacto = persistencia.getTiposContacto();
		for (TipoContacto e : tiposcontacto) {
			assertEquals(e.getClass(), TipoContacto.class);
		}
	}

	/**
	 * Cierre de persistencia
	 */
	public void test10CierraPersistencia() {
		persistencia.close();
		// assertNull(persistencia);
	}

}
