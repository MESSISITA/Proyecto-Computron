package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import vistas.MenuPrincipal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblProducto;
	private JComboBox cboCodigo;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JLabel lblVentas;
	private MenuPrincipal menuprincipal;
	private JButton btnBuscar;
	private JTextArea txtBoleta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		
		setTitle("Ventas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\perez\\Downloads\\ventas.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 610);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 59, 93));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblApellido = new JLabel("Apellidos del cliente:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblApellido.setBounds(10, 89, 187, 33);
		contentPane.add(lblApellido);
		
		lblNombre = new JLabel("Nombres del cliente:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNombre.setBounds(10, 47, 187, 33);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(167, 51, 169, 27);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setEditable(false);
		
		JTextField txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(167, 91, 335, 27);
		txtApellido.setEditable(false);
		contentPane.add(txtApellido);
		
		lblProducto = new JLabel("C\u00F3digo del producto:");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblProducto.setBounds(10, 133, 187, 33);
		contentPane.add(lblProducto);
		
		cboCodigo = new JComboBox();
		cboCodigo.setBounds(167, 133, 335, 27);
		contentPane.add(cboCodigo);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCantidad.setBounds(10, 171, 187, 33);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(167, 177, 335, 27);
		contentPane.add(txtCantidad);
		
		btnNewButton = new JButton("Generar boleta");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnNewButton.setBounds(607, 53, 157, 137);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 774, 345);
		contentPane.add(scrollPane);
		
		txtBoleta = new JTextArea();
		txtBoleta.setEditable(false);
		scrollPane.setViewportView(txtBoleta);
		
		lblVentas = new JLabel("Ventas");
		lblVentas.setForeground(Color.WHITE);
		lblVentas.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblVentas.setBounds(364, 1, 134, 35);
		contentPane.add(lblVentas);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(0, 128, 255));
		btnBuscar.setBounds(364, 47, 138, 33);
		contentPane.add(btnBuscar);
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuPrincipal.setVisible(true); 
            }
        });
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		JOptionPane.showMessageDialog(this, "Venta realizada con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}
}