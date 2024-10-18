package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloProductos;
import arreglos.ArregloVenta;
import clases.Producto;
import clases.Venta;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Reportes extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTextArea textResponse;
    private JComboBox<String> comboTipoReporte;
    private JButton closeButton;
    private JMenuBar menuBar;
    private JMenu mnReportes;
    private JMenuItem miListadoVentas, miStockMinimo, miUnidadesVendidas, miImporteTotal;
    private MenuPrincipal menuPrincipal;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reportes frame = new Reportes();
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
    public Reportes() {
        setTitle("Reportes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(234, 240, 246));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        // Configurar el panel central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(null);
        contentPane.add(panelCentral, BorderLayout.CENTER);
        
        // Label para el ComboBox
        JLabel lblNewLabel = new JLabel("Tipo de reporte:");
        lblNewLabel.setBounds(10, 21, 100, 14);
        panelCentral.add(lblNewLabel);
        
        // ComboBox para selección de reportes
        comboTipoReporte = new JComboBox<>();
        comboTipoReporte.addActionListener(this);
        comboTipoReporte.setModel(new DefaultComboBoxModel<>(new String[]{
            "Listado general de ventas",
            "Productos con stock bajo el mínimo",
            "Productos por unidades vendidas acumuladas",
            "Productos por importe total acumulado"
        }));
        comboTipoReporte.setBounds(120, 17, 240, 22);
        panelCentral.add(comboTipoReporte);
        
        // JScrollPane y JTextArea para mostrar los reportes
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 614, 250);
        panelCentral.add(scrollPane);

        textResponse = new JTextArea();
        textResponse.setEditable(false);
        scrollPane.setViewportView(textResponse);
        
        // Panel para botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        closeButton = new JButton("Cerrar");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        // Crear JMenuBar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear JMenu Reportes
        mnReportes = new JMenu("Reportes");
        menuBar.add(mnReportes);

        // Opciones de reportes
        miListadoVentas = new JMenuItem("Listado General de Ventas");
        miListadoVentas.addActionListener(this);
        mnReportes.add(miListadoVentas);

        miStockMinimo = new JMenuItem("Listado de Productos por Stock Mínimo");
        miStockMinimo.addActionListener(this);
        mnReportes.add(miStockMinimo);

        miUnidadesVendidas = new JMenuItem("Listado de Productos por Unidades Vendidas");
        miUnidadesVendidas.addActionListener(this);
        mnReportes.add(miUnidadesVendidas);

        miImporteTotal = new JMenuItem("Listado de Productos por Importe Total Acumulado");
        miImporteTotal.addActionListener(this);
        mnReportes.add(miImporteTotal);
        
        menuPrincipal = new MenuPrincipal();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuPrincipal.setVisible(true);
            }
        });
    }

    ArregloProductos arregloProducto = new ArregloProductos();
    ArregloVenta arregloVenta = new ArregloVenta();

    // Manejo de los eventos de los menús y componentes
    protected void actionPerformedCancelButton(ActionEvent e) {
        this.dispose();
    }

    protected void actionPerformedComboBox(ActionEvent e) {
        switch (comboTipoReporte.getSelectedIndex()) {
            case 0:
                obtenerListadoGeneralVentas();
                break;
            case 1:
                obtenerProductosConStockBajo();
                break;
            case 2:
                obtenerProductosPorUnidadesVendidas();
                break;
            case 3:
                obtenerProductosPorImporteTotal();
                break;
            default:
                textResponse.setText("Seleccione un reporte válido.");
                break;
        }
    }

    private void obtenerListadoGeneralVentas() {
        textResponse.setText("LISTADO GENERAL DE VENTAS\n\n");
        for (int i = 0; i < arregloVenta.obtenerVentas().size(); i++) {
            Venta v = arregloVenta.obtenerVentas().get(i);
            textResponse.append("Código de Venta: " + v.getCodigoVenta() + "\n");
            textResponse.append("Código de Cliente: " + v.getCodigoCliente() + "\n");
            textResponse.append("Código de Producto: " + v.getCodigoProducto() + "\n");
            textResponse.append("Fecha: " + v.getFecha() + "\n");
            textResponse.append("Importe Subtotal: $" + v.getImporteSubtotal() + "\n");
            textResponse.append("Importe IGV: $" + v.getImporteIgv() + "\n");
            textResponse.append("Importe Total: $" + v.getImporteTotal() + "\n");
            textResponse.append("------------------------\n");
        }
    }

    private void obtenerProductosConStockBajo() {
        textResponse.setText("PRODUCTOS CON STOCK BAJO EL MÍNIMO\n\n");
        boolean hayProductosBajoStock = false;

        for (int i = 0; i < arregloProducto.tamano(); i++) {
            Producto p = arregloProducto.obtener(i);
            if (p.getStockActual() < p.getStockMinimo()) {
                hayProductosBajoStock = true;
                textResponse.append("Código: " + p.getCodigo() + "\n");
                textResponse.append("Nombre: " + p.getNombre() + "\n");
                textResponse.append("Stock Actual: " + p.getStockActual() + "\n");
                textResponse.append("Stock Mínimo: " + p.getStockMinimo() + "\n");
                textResponse.append("------------------------\n");
            }
        }

        if (!hayProductosBajoStock) {
            textResponse.append("No hay productos con stock bajo el mínimo.\n");
        }
    }

    private void obtenerProductosPorUnidadesVendidas() {
        textResponse.setText("PRODUCTOS POR UNIDADES VENDIDAS ACUMULADAS\n\n");
        for (int i = 0; i < arregloProducto.tamano(); i++) {
        	Producto p = arregloProducto.obtener(i);
            int unidadesVendidas = calcularUnidadesVendidas(p);
            textResponse.append("Código: " + p.getCodigo() + "\n");
            textResponse.append("Nombre: " + p.getNombre() + "\n");
            textResponse.append("Unidades Vendidas Acumuladas: " + unidadesVendidas + "\n");
            textResponse.append("------------------------\n");
        }
    }

    private void obtenerProductosPorImporteTotal() {
        textResponse.setText("PRODUCTOS POR IMPORTE TOTAL ACUMULADO\n\n");
        for (int i = 0; i < arregloProducto.tamano(); i++) {
        	Producto p = arregloProducto.obtener(i);
            double importeTotalAcumulado = calcularImporteTotal(p);
            textResponse.append("Código: " + p.getCodigo() + "\n");
            textResponse.append("Nombre: " + p.getNombre() + "\n");
            textResponse.append("Importe Total Acumulado: $" + importeTotalAcumulado + "\n");
            textResponse.append("------------------------\n");
        }
    }

    private int calcularUnidadesVendidas(Producto producto) {
        int totalUnidades = 0;
        for (int i = 0; i < arregloVenta.obtenerVentas().size(); i++) {
            Venta v = arregloVenta.obtenerVentas().get(i);
            if (v.getCodigoProducto() == producto.getCodigo()) {
                totalUnidades += v.getCantidad();
            }
        }
        return totalUnidades;
    }

    private double calcularImporteTotal(Producto producto) {
        double totalImporte = 0.0;
        for (int i = 0; i < arregloVenta.obtenerVentas().size(); i++) {
            Venta v = arregloVenta.obtenerVentas().get(i);
            if (v.getCodigoProducto() == producto.getCodigo()) {
                totalImporte += v.getImporteTotal();
            }
        }
        return totalImporte;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
