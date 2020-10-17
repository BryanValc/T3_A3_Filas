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
	private int tama�o;
	private int cntHojas;
	
	public Impresion() {
	}
	public Impresion(int id, int tama�o, int cntHojas) {
		this.id = id;
		this.tama�o = tama�o;
		this.cntHojas = cntHojas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTama�o() {
		return tama�o;
	}
	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}
	public int getCntHojas() {
		return cntHojas;
	}
	public void setCntHojas(int cntHojas) {
		this.cntHojas = cntHojas;
	}
	
	@Override
	public String toString() {
		return "Impresion [id=" + id + ", tama�o=" + tama�o + ", cntHojas=" + cntHojas + "]";
	}	

}



public class PruebaFilas {

	public static void main(String[] args) {
		
		

	}

}