package vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Reportes extends JFrame implements ActionListener {

    private JPanel contentPane;

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
        setTitle("Mas frio que felpudini - Reportes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 833, 529);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 59, 93));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Reportes.class.getResource("/imagenes/LogoCibertec.jpg")));
        lblNewLabel.setBounds(265, -133, 664, 726);
        contentPane.add(lblNewLabel);

        // Crear JMenuBar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear JMenu Reportes
        JMenu mnReportes = new JMenu("Reportes");
        menuBar.add(mnReportes);

        // Opciones de reportes
        JMenuItem miListadoVentas = new JMenuItem("Listado General de Ventas");
        miListadoVentas.addActionListener(this);
        mnReportes.add(miListadoVentas);

        JMenuItem miStockMinimo = new JMenuItem("Listado de Productos por Stock Mínimo");
        miStockMinimo.addActionListener(this);
        mnReportes.add(miStockMinimo);

        JMenuItem miUnidadesVendidas = new JMenuItem("Listado de Productos por Unidades Vendidas");
        miUnidadesVendidas.addActionListener(this);
        mnReportes.add(miUnidadesVendidas);

        JMenuItem miImporteTotal = new JMenuItem("Listado de Productos por Importe Total Acumulado");
        miImporteTotal.addActionListener(this);
        mnReportes.add(miImporteTotal);
    }

    // Manejo de los eventos de los menús
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        String option = source.getText();

        switch (option) {
            case "Listado General de Ventas":
                JOptionPane.showMessageDialog(this, "Generando Listado General de Ventas...");
                // Aquí puedes implementar la lógica para mostrar el listado de ventas
                break;
            case "Listado de Productos por Stock Mínimo":
                JOptionPane.showMessageDialog(this, "Generando Listado de Productos por Stock Mínimo...");
                // Aquí puedes implementar la lógica para mostrar el listado de productos por stock mínimo
                break;
            case "Listado de Productos por Unidades Vendidas":
                JOptionPane.showMessageDialog(this, "Generando Listado de Productos por Unidades Vendidas...");
                // Aquí puedes implementar la lógica para mostrar el listado de productos por unidades vendidas
                break;
            case "Listado de Productos por Importe Total Acumulado":
                JOptionPane.showMessageDialog(this, "Generando Listado de Productos por Importe Total Acumulado...");
                // Aquí puedes implementar la lógica para mostrar el listado de productos por importe total acumulado
                break;
            default:
                break;
        }
    }
}
