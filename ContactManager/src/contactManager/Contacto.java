package contactManager;

public class Contacto implements Comparable<Contacto>{
	
	private String nombre;
	private int prefix;
	private String number;
	
	public Contacto(String nombre, int prefix, String number) {
		this.nombre = nombre;
		this.prefix = prefix;
		this.number = number;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNumber() {
		return number;
	}
	
	public int getPrefix() {
		return prefix;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
	
	public String toString() {
		return "Contacto: " + this.nombre + ", Número: +" + this.prefix + " " + this.number;
	}
	
	@Override
    public int compareTo(Contacto o) {
        int cmp = this.nombre.compareTo(o.nombre);
        
        if (cmp == 0) {
            return this.number.compareTo(o.number); // Comparar también por número
        }
        return cmp;
    }
}