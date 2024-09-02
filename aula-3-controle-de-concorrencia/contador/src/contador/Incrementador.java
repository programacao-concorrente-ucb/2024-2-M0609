package contador;

public class Incrementador extends Thread {
	private Contador cont;
	public Incrementador(Contador cont) {
		this.cont = cont;
	}
	
	public void run() {
		cont.incrementa();
	}
}
