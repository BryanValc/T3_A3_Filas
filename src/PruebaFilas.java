import java.util.Arrays;

interface RegistroImpresiones{
	public boolean filaLlena();
	public void insertar(Impresion impresion);
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

class ImplementacionFilaEstatica implements RegistroImpresiones{
	private Impresion registro[];
	private int frente;

	public ImplementacionFilaEstatica() {
	}
	public ImplementacionFilaEstatica(int tamaño) {
		this.registro = new Impresion[tamaño];
		this.frente = -1;
	}
	
	public Impresion[] getRegistro() {
		return registro;
	}
	public void setRegistro(Impresion[] registro) {
		this.registro = registro;
	}
	public int getFrente() {
		return frente;
	}
	public void setFrente(int frente) {
		this.frente = frente;
	}
	
	public boolean filaLlena() {
		return this.getFrente()==(this.getRegistro().length-1);
	}
	public void insertar(Impresion impresion) {
		if (this.filaLlena()){
			System.out.println("Fila llena");
		}else {
			this.setFrente(this.getFrente()+1);
			Impresion datos[]=this.getRegistro();
			Impresion datost[]=datos;
			int fr=this.getFrente();
			for (int i = fr; i > 0; i--) {
				datost[i]=datos[i-1];
			}
			
			datost[0]=impresion;
			this.setRegistro(datost);
		}
	}
	public boolean filaVacia() {
		return (frente==(-1));
	}
	public Impresion sacar() {
		if (this.filaVacia()){
			System.out.println("Fila vacia");
			return null;
		}else {
			int fr = this.getFrente();
			Impresion datos[]=this.getRegistro();
			Impresion datosr[]=new Impresion[this.getRegistro().length];
			for (int i = 0; i < fr; i++) {
				datosr[i]=datos[i];
			}
			this.setRegistro(datosr);
			this.setFrente(this.getFrente()-1);
			return datos[fr];
		}
	}
	public void mostrarFrente() {
		if (this.filaVacia()) {
			System.out.println("Fila vacia");
		}else {
			Impresion datos[]=this.getRegistro();
			int fr=this.getFrente();
			System.out.println("Frente: "+datos[fr]);
		}
	}
	public void totalImpresas() {
		Impresion datos[]=this.getRegistro();
		int sum=0;
		for (int i = 0; i < datos.length; i++) {
			Impresion tmp = datos[i];
			sum+=tmp.getCntHojas();
		}
		System.out.println("Total de hojas impresas: "+sum);
	}
	public void totalBytes() {
		Impresion datos[]=this.getRegistro();
		int sum=0;
		for (int i = 0; i < datos.length; i++) {
			Impresion tmp = datos[i];
			sum+=tmp.getTamaño();
		}
		System.out.println("Total de bytes recibidos: "+sum);
	}
	
	@Override
	public String toString() {
		return "ImplementacionFilaEstatica [registro=" + Arrays.toString(registro) + ", frente=" + frente + "]";
	}
	

}

public class PruebaFilas {

	public static void main(String[] args) {
		
		Impresion i1 = new Impresion(10,20,30);
		System.out.println(i1);
		Impresion i2 = new Impresion(40,50,60);
		System.out.println(i1);
		ImplementacionFilaEstatica ife1 = new ImplementacionFilaEstatica(2);
		ife1.insertar(i1);
		ife1.insertar(i2);
		System.out.println(ife1);
		ife1.sacar();
		System.out.println(ife1);
		ife1.sacar();
		System.out.println(ife1);
		ife1.sacar();

	}

}