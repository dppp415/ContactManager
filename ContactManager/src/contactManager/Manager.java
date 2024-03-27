package contactManager;

import java.util.ArrayList;
import java.util.Collections;

public class Manager {
	private ArrayList<Contacto> contactos;
	
	public Manager() {
		this.contactos = new ArrayList<Contacto>();
	}
	
	public boolean add(Contacto a) {
		return (this.contactos.indexOf(a) == -1) ? this.contactos.add(a): false;
	}
	
	public Contacto remove(Contacto a) {
		int index = this.contactos.indexOf(a);
		return (index == -1) ? null: this.contactos.remove(index);
	}
	
	public void clear() {
		this.contactos.clear();
	}
	
	public ArrayList<Contacto> getContactos() {
        return contactos;
    }
	
	public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
	
	public void sort() {
		Collections.sort(this.contactos);
	}
	
	public String toString() {
		return contactos.toString();
	}
	
}
