import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

class ImplementacionFilaEstatica implements RegistroImpresiones{
	private Impresion registro[];
	private int frente;

	public ImplementacionFilaEstatica() {
	}
	public ImplementacionFilaEstatica(int tama�o) {
		this.registro = new Impresion[tama�o];
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
			sum+=tmp.getTama�o();
		}
		System.out.println("Total de bytes recibidos: "+sum);
	}
	
	@Override
	public String toString() {
		return "ImplementacionFilaEstatica [registro=" + Arrays.toString(registro) + ", frente=" + frente + "]";
	}
	

}

class ImplementacionFilaDinamica implements RegistroImpresiones{
	private Queue<Impresion> registro = new LinkedList<Impresion>();

	/*public ImplementacionFilaDinamica(Queue<Impresion> registro) {
		super();
		this.registro = registro;
	}*/
	public Queue<Impresion> getRegistro() {
		return registro;
	}
	public void setRegistro(Queue<Impresion> registro) {
		this.registro = registro;
	}
	
	@Override
	public boolean filaLlena() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void insertar(Impresion impresion) {
		Queue<Impresion> registro=this.getRegistro();
		registro.add(impresion);
		this.setRegistro(registro);
	}
	@Override
	public boolean filaVacia() {
		Queue<Impresion> registro=this.getRegistro();
		return registro.isEmpty();
	}
	@Override
	public Impresion sacar() {
		if (this.filaVacia()) {
			System.out.println("Fila vacia");
			return null;
		}else {
			Queue<Impresion> registro=this.getRegistro();
			return registro.poll();
		}
	}
	@Override
	public void mostrarFrente() {
		if (this.filaVacia()) {
			System.out.println("Fila vacia");
		}else {
			Queue<Impresion> registro=this.getRegistro();
			Impresion frente = registro.peek();
			System.out.println(frente);
		}
	}
	@Override
	public void totalImpresas() {
		Queue<Impresion> reg=this.getRegistro();
		int sum=0;
		for (int i=0;i<reg.size();i++) {
			Impresion tmp = reg.poll();
			sum+=tmp.getCntHojas();
			reg.add(tmp);
		}
		System.out.println("Total de hojas impresas: "+sum);
	}
	@Override
	public void totalBytes() {
		Queue<Impresion> reg=this.getRegistro();
		int sum=0;
		for (int i=0;i<reg.size();i++) {
			Impresion tmp = reg.poll();
			sum+=tmp.getTama�o();
			reg.add(tmp);
		}
		System.out.println("Total de bytes recibidos: "+sum);
	}
	
	@Override
	public String toString() {
		return "ImplementacionFilaDinamica [registro=" + registro + "]";
	}
	
	
}

public class PruebaFilas {

	public static void main(String[] args) {
		
		Impresion i1 = new Impresion(10,20,30);
		System.out.println(i1);
		Impresion i2 = new Impresion(40,50,60);
		System.out.println(i1);
		Impresion i3 = new Impresion(70,80,90);
		System.out.println(i1);
		ImplementacionFilaEstatica ife1 = new ImplementacionFilaEstatica(2);
		ImplementacionFilaDinamica ifd1 = new ImplementacionFilaDinamica();
		
		ifd1.insertar(i1);
		ifd1.insertar(i2);
		ifd1.insertar(i3);
		ifd1.totalBytes();
		ifd1.totalImpresas();
		
		System.out.println(ifd1);
		ifd1.sacar();
		System.out.println(ifd1);
		ifd1.sacar();
		System.out.println(ifd1);
		ifd1.sacar();
		
		/*ife1.insertar(i1);
		ife1.insertar(i2);
		System.out.println(ife1);
		ife1.sacar();
		System.out.println(ife1);
		ife1.sacar();
		System.out.println(ife1);
		ife1.sacar();*/
		
		

		
		
	}

}