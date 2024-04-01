package contactManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

public class VentanaContacto extends JFrame {

	private static final long serialVersionUID = 1L;
	private Manager manager;
    private DefaultListModel<Contacto> contactosListModel;
    private JList<Contacto> contactosList;
    private JTextField nombreField;
    private JTextField prefixField;
    private JTextField numeroField;
    private JButton editarButton;
    private JButton agregarButton;
    private int indiceSeleccionado = -1;

    public VentanaContacto(Manager manager) {
        this.manager = manager;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestor de Contactos");
        
        JLabel tituloLabel = new JLabel("Lista de Contactos");
        tituloLabel.setBounds(10, 10, 150, 30);
        add(tituloLabel);
        
        nombreField = new JTextField(20);
        prefixField = new JTextField(5);
        numeroField = new JTextField(10);

        contactosListModel = new DefaultListModel<>();
        contactosList = new JList<>(contactosListModel);
        contactosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactosList.addListSelectionListener(e -> mostrarDetalleContacto());
        JScrollPane scrollPane = new JScrollPane(contactosList);
        scrollPane.setBounds(10, 50, 700, 300);
        add(scrollPane);

        agregarButton = new JButton("Agregar Contacto");
        agregarButton.setBounds(275, 10, 150, 30);
        agregarButton.addActionListener(e -> agregarContacto());
        add(agregarButton);
        
        editarButton = new JButton("Editar");
        editarButton.setBounds(150, 10, 100, 30);
        editarButton.addActionListener(e -> editarContacto());
        add(editarButton);

        mostrarContactos();

        setSize(750, 400);
        setLayout(null);
        setVisible(true);
    }
    
    private void agregarContacto() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Prefijo:"));
        panel.add(prefixField);
        panel.add(new JLabel("Número:"));
        panel.add(numeroField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Añadir Contacto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String nuevoNombre = nombreField.getText();
            int nuevoPrefix = Integer.parseInt(prefixField.getText());
            String nuevoNumero = numeroField.getText();
            Contacto nuevoContacto = new Contacto(nuevoNombre, nuevoPrefix, nuevoNumero);
            manager.add(nuevoContacto);
            mostrarContactos();
        }
    }
    
    private void editarContacto() {
        if (indiceSeleccionado != -1) {
            Contacto contactoSeleccionado = contactosListModel.getElementAt(indiceSeleccionado);
            nombreField = new JTextField(contactoSeleccionado.getNombre(), 20);
            prefixField = new JTextField(String.valueOf(contactoSeleccionado.getPrefix()), 5);
            numeroField = new JTextField(contactoSeleccionado.getNumber(), 10);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Nombre:"));
            panel.add(nombreField);
            panel.add(new JLabel("Prefijo:"));
            panel.add(prefixField);
            panel.add(new JLabel("Número:"));
            panel.add(numeroField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Editar Contacto",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String nuevoNombre = nombreField.getText();
                int nuevoPrefix = Integer.parseInt(prefixField.getText());
                String nuevoNumero = numeroField.getText();
                Contacto contactoModificado = new Contacto(nuevoNombre, nuevoPrefix, nuevoNumero);
                manager.getContactos().set(indiceSeleccionado, contactoModificado);
                mostrarContactos();
            }
        }
    }

    
    private void mostrarContactos() {
        contactosListModel.clear();
        ArrayList<Contacto> contactos = manager.getContactos();
        for (Contacto contacto : contactos) {
            contactosListModel.addElement(contacto);
        }
    }
    
    private void mostrarDetalleContacto() {
        indiceSeleccionado = contactosList.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            Contacto contactoSeleccionado = contactosListModel.getElementAt(indiceSeleccionado);
            nombreField.setText(contactoSeleccionado.getNombre());
            prefixField.setText(String.valueOf(contactoSeleccionado.getPrefix()));
            numeroField.setText(contactoSeleccionado.getNumber());
        }
    }

    public static void main(String[] args) {
    	Manager manager = new Manager();
        VentanaContacto ventana = new VentanaContacto(manager);
    }
}
