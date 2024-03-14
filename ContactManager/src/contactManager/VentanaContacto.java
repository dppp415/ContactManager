package contactManager;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaContacto extends JFrame {

	private static final long serialVersionUID = 1L;
	private Contacto contacto;

    public VentanaContacto(Contacto contacto) {
        this.contacto = contacto;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Información de Contacto");

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 10, 100, 30);
        add(nombreLabel);

        JLabel nombreValorLabel = new JLabel(contacto.getNombre());
        nombreValorLabel.setBounds(120, 10, 200, 30);
        add(nombreValorLabel);

        JLabel numeroLabel = new JLabel("Número:");
        numeroLabel.setBounds(10, 90, 100, 30);
        add(numeroLabel);

        JLabel numeroValorLabel = new JLabel("+" + contacto.getPrefix()+ " " + Integer.toString(contacto.getNumber()));
        numeroValorLabel.setBounds(120, 90, 200, 30);
        add(numeroValorLabel);

        setSize(350, 170);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Contacto contacto = new Contacto("David", 34, 123456789);
        new VentanaContacto(contacto);
    }
}
