import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class AplicacionNotasGUI extends JFrame {

    private static final Color COLOR_FONDO = new Color(245, 248, 252);
    private static final Color COLOR_TITULO = new Color(20, 70, 140);
    private static final Color COLOR_BOTON_AZUL = new Color(30, 100, 180);
    private static final Color COLOR_BOTON_VERDE = new Color(40, 140, 90);
    private static final Color COLOR_BOTON_ROJO = new Color(180, 60, 60);
    private static final Color COLOR_BOTON_GRIS = new Color(90, 100, 110);

    private JTextField txtCodigo, txtNombre, txtNota1, txtNota2, txtNota3;
    private JComboBox<String> cmbPrograma;
    private JRadioButton rbDiurna, rbNocturna;
    private ButtonGroup grupoJornada;
    private JTable tablaEstudiantes;
    private DefaultTableModel modeloTabla;
    private JLabel lblEstado, lblResumen;

    public AplicacionNotasGUI() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Registro de estudiantes");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        JPanel contenedor = new JPanel(new BorderLayout(10, 10));
        contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contenedor.setBackground(COLOR_FONDO);
        setContentPane(contenedor);

        contenedor.add(crearPanelTitulo(), BorderLayout.NORTH);
        contenedor.add(crearPanelFormulario(), BorderLayout.WEST);
        contenedor.add(crearPanelTabla(), BorderLayout.CENTER);
        contenedor.add(crearPanelInferior(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelTitulo() {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_FONDO);

        JLabel titulo = new JLabel("Sistema de registro de estudiantes");
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setForeground(COLOR_TITULO);

        panel.add(titulo);
        return panel;
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createTitledBorder("Datos del estudiante"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtCodigo = new JTextField(15);
        txtNombre = new JTextField(15);
        txtNota1 = new JTextField(15);
        txtNota2 = new JTextField(15);
        txtNota3 = new JTextField(15);

        cmbPrograma = new JComboBox<>(new String[]{
                "Ingenieria Electronica",
                "Ingenieria Mecatronica",
                "Ingenieria de Sistemas",
                "Tecnologia Electronica",
                "Otro"
        });

        rbDiurna = new JRadioButton("Diurna");
        rbNocturna = new JRadioButton("Nocturna");
        rbDiurna.setSelected(true);

        grupoJornada = new ButtonGroup();
        grupoJornada.add(rbDiurna);
        grupoJornada.add(rbNocturna);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnGuardarCSV = new JButton("Guardar CSV");
        JButton btnSalir = new JButton("Salir");

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Codigo:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCodigo, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Programa:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbPrograma, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Jornada:"), gbc);
        gbc.gridx = 1;
        panel.add(rbDiurna, gbc);
        gbc.gridx = 2;
        panel.add(rbNocturna, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Nota 1:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNota1, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Nota 2:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNota2, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        panel.add(new JLabel("Nota 3:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNota3, gbc);

        gbc.gridy = 7; gbc.gridx = 0;
        panel.add(btnAgregar, gbc);
        gbc.gridx = 1;
        panel.add(btnLimpiar, gbc);

        gbc.gridy = 8; gbc.gridx = 0;
        panel.add(btnEliminar, gbc);
        gbc.gridx = 1;
        panel.add(btnGuardarCSV, gbc);

        gbc.gridy = 9; gbc.gridx = 0;
        panel.add(btnSalir, gbc);

        btnAgregar.addActionListener(e -> agregarEstudiante());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnEliminar.addActionListener(e -> eliminarFilaSeleccionada());
        btnGuardarCSV.addActionListener(e -> guardarCSV());
        btnSalir.addActionListener(e -> salirAplicacion());

        return panel;
    }

    private JScrollPane crearPanelTabla() {
        String[] columnas = {"Codigo", "Nombre", "Programa", "Jornada",
                "Nota1", "Nota2", "Nota3", "Definitiva", "Estado"};

        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEstudiantes = new JTable(modeloTabla);

        return new JScrollPane(tablaEstudiantes);
    }

    private JPanel crearPanelInferior() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        lblEstado = new JLabel("Ingrese datos");
        lblResumen = new JLabel("Registros: 0");
        panel.add(lblEstado);
        panel.add(lblResumen);
        return panel;
    }

    private void agregarEstudiante() {
        try {
            Estudiante e = new Estudiante(
                    txtCodigo.getText(),
                    txtNombre.getText(),
                    cmbPrograma.getSelectedItem().toString(),
                    rbDiurna.isSelected() ? "Diurna" : "Nocturna",
                    Double.parseDouble(txtNota1.getText()),
                    Double.parseDouble(txtNota2.getText()),
                    Double.parseDouble(txtNota3.getText())
            );

            modeloTabla.addRow(new Object[]{
                    e.getCodigo(), e.getNombre(), e.getPrograma(),
                    e.getJornada(), e.getNota1(), e.getNota2(),
                    e.getNota3(),
                    String.format(Locale.US, "%.2f", e.calcularDefinitiva()),
                    e.obtenerEstado()
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en datos");
        }
    }

    private void limpiarFormulario() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
    }

    private void eliminarFilaSeleccionada() {
        int fila = tablaEstudiantes.getSelectedRow();
        if (fila != -1) modeloTabla.removeRow(fila);
    }

    private void guardarCSV() {
        try (PrintWriter pw = new PrintWriter(new File("estudiantes.csv"))) {
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                    pw.print(modeloTabla.getValueAt(i, j) + ";");
                }
                pw.println();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar");
        }
    }

    private void salirAplicacion() {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplicacionNotasGUI().setVisible(true));
    }
}