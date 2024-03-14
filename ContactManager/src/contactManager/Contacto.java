package contactManager;

public class Contacto implements Comparable<Contacto>{
	
	private String nombre;
	private int prefix;
	private int number;
	
	public Contacto(String nombre, int prefix, int number) {
		this.nombre = nombre;
		this.prefix = prefix;
		this.number = number;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getPrefix() {
		return prefix;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumber(int number) {
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
	        if (this.number == o.number) {
	            return 0;
	        } else if (this.number < o.number) {
	            return -1;
	        } else {
	            return 1;
	        }
	    }
	    return cmp;
	}

	
}