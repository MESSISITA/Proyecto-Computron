package vistas;

import java.awt.EventQueue;



import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vistas.Ventas;
import vistas.Almacen;
import vistas.Reportes;
import java.awt.Color;

public class MenuPrincipal extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JMenu mnVentas;
    private JMenuItem mntmClientes;
    private JMenuItem mntmProductos;
    private JMenuItem mntmAlmacen;
    private JMenuItem mntmReportes;
    private JMenuItem mntmRegistroVentas;
    private JMenu mnArchivo;
    private JMenuItem mntmSalir;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
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
    public MenuPrincipal() {
    	
    	setTitle("ChulloTec");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1008, 592);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 59, 93));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear JMenuBar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnArchivo = new JMenu("Archivo");
        menuBar.add(mnArchivo);
        
        mntmSalir = new JMenuItem("Salir");
        mntmSalir.addActionListener(this);
        mnArchivo.add(mntmSalir);

        // Crear JMenu Mantenimiento
        JMenu mnMantenimiento = new JMenu("Mantenimiento");
        menuBar.add(mnMantenimiento);

        // Subopciones del menú Mantenimiento
        mntmClientes = new JMenuItem("Clientes");
        mntmClientes.addActionListener(this);
        mnMantenimiento.add(mntmClientes);

        mntmProductos = new JMenuItem("Productos");
        mntmProductos.addActionListener(this);
        mnMantenimiento.add(mntmProductos);

        // Otras opciones del menú principal
        mnVentas = new JMenu("Ventas");
        mnVentas.addActionListener(this);
        menuBar.add(mnVentas);
        
        mntmRegistroVentas = new JMenuItem("Registro de ventas");
        mntmRegistroVentas.addActionListener(this);
        mnVentas.add(mntmRegistroVentas);

        JMenu mnAlmacen = new JMenu("Almacén");
        menuBar.add(mnAlmacen);
        
        mntmAlmacen = new JMenuItem("Ir a Almacen");
        mntmAlmacen.addActionListener(this);
        mnAlmacen.add(mntmAlmacen);

        JMenu mnReportes = new JMenu("Reportes");
        menuBar.add(mnReportes);
        
        mntmReportes = new JMenuItem("Ir reportes");
        mntmReportes.addActionListener(this);
        mnReportes.add(mntmReportes);

        // Cargar imagen de Felpudini
        ImageIcon icon = new ImageIcon("ruta/a/tu/imagen/felpudini.jpg");
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmRegistroVentas) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmReportes) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmAlmacen) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMiProductos(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMiClientes(e);
		}
	}
	
	/* Mantenimiento Clientes */
	protected void actionPerformedMiClientes(ActionEvent e) {
		
	}
	
	
	/*Mantenimiento Productos*/
	protected void actionPerformedMiProductos(ActionEvent e) {
		
	}
	
	/* Ventas */
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		Ventas v = new Ventas(this);
		v.setVisible(true);
		this.setVisible(false);
	}
	
	/* Almacen */
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		Almacen a = new Almacen();
		a.setVisible(true);
		this.setVisible(false);

	}
	
	/* Reportes */
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		Reportes r = new Reportes();
		r.setVisible(true);
		this.setVisible(false);
	}
	
	/* Salir */
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
}