interface RegistroImpresiones{
	public boolean filaLlena();
	public void insertar();
	public boolean filaVacia();
	public Impresion sacar();
	public void mostrarFrente();
	public void totalImpresas();
	public void totalBytes();
}

class Impresion{
	private int id;
	private int tamaño;
	private int cntHojas;
	
	public Impresion() {
	}
	public Impresion(int id, int tamaño, int cntHojas) {
		this.id = id;
		this.tamaño = tamaño;
		this.cntHojas = cntHojas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public int getCntHojas() {
		return cntHojas;
	}
	public void setCntHojas(int cntHojas) {
		this.cntHojas = cntHojas;
	}
	
	@Override
	public String toString() {
		return "Impresion [id=" + id + ", tamaño=" + tamaño + ", cntHojas=" + cntHojas + "]";
	}	

}



public class PruebaFilas {

	public static void main(String[] args) {
		
		

	}

}