package ubu.lsi.dms.agenda.ui.grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import ubu.lsi.dms.agenda.persistencia.Persistencia;
import ubu.lsi.dms.agenda.ui.grafica.panel.accion.PanelAcciones;
import ubu.lsi.dms.agenda.ui.grafica.panel.entidades.ContenedorPanelesEntidades;

/**
 * Aplicación de ventana que realiza el mantenimiento de una base de datos de
 * contactos. Esto es el interfaz de usuario gráfico.
 * 
 * @author José Ramón Cuevas Diez
 * 
 */
public class AgendaGUI extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelAcciones panelAcciones;
	private ContenedorPanelesEntidades contenedorPanelesEntidades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaGUI frame = new AgendaGUI();
					//Añade oyente para capturar el cierre
					frame.addWindowListener(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgendaGUI() {
		// Crea la ventana principal
		contentPane = creaVentanaAgenda();

		// Crea el panel de acciones
		panelAcciones = new PanelAcciones(contentPane);

		// Crea el contenedor de los paneles de entidades
		contenedorPanelesEntidades = new ContenedorPanelesEntidades(contentPane);

		// Informa al panel de acciones de que objeto recibirá las acciones.
		panelAcciones.addReceptorAcciones(contenedorPanelesEntidades);

		// Informa al panel de entidades, de quien quiere ser avisado de algún
		// cambio.
		contenedorPanelesEntidades.addObserver(panelAcciones);

		// Indica al contenedor de paneles de entidades que su estado a
		// cambiado, de esta forma le obligamos a que informe de su estado a los
		// observadores cuando se inicialice.
		contenedorPanelesEntidades.stateChanged(null);
	}

	private JPanel creaVentanaAgenda() {
		// Atributos
		setResizable(false);
		setTitle("Agenda");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Inhibido para poder liberar recursos al salir
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 459, 465);

		// Contenedor ventana
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		return contentPane;
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void windowClosing(WindowEvent e) {
		Persistencia.close();
		this.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

}
