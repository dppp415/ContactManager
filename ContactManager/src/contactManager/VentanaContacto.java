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

        contactosListModel = new DefaultListModel<>();
        contactosList = new JList<>(contactosListModel);
        JScrollPane scrollPane = new JScrollPane(contactosList);
        scrollPane.setBounds(10, 50, 320, 150);
        add(scrollPane);

        JButton agregarButton = new JButton("Agregar Contacto");
        agregarButton.setBounds(200, 10, 150, 30);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });
        add(agregarButton);

        mostrarContactos();

        setSize(350, 250);
        setLayout(null);
        setVisible(true);
    }
    
    private void mostrarContactos() {
        contactosListModel.clear();
        ArrayList<Contacto> contactos = manager.getContactos();
        for (Contacto contacto : contactos) {
            contactosListModel.addElement(contacto);
        }
    }
    
    private void agregarContacto() {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre:");
        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el nombre está vacío
        }
        
        String prefixStr = JOptionPane.showInputDialog("Introduce el prefijo:");
        if (prefixStr == null || prefixStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir un prefijo.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el prefijo está vacío
        }
        
        int prefix;
        try {
            prefix = Integer.parseInt(prefixStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El prefijo debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el prefijo no es un número válido
        }
        
        String numero = JOptionPane.showInputDialog("Introduce el número:");
        if (numero == null || numero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el número está vacío
        }

        Contacto nuevoContacto = new Contacto(nombre, prefix, numero);
        manager.add(nuevoContacto);
        mostrarContactos();
    }

    public static void main(String[] args) {
    	Manager manager = new Manager();
        VentanaContacto ventana = new VentanaContacto(manager);
    }
}
