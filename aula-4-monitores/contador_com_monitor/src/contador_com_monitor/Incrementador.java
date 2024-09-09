package contador_com_monitor;

public class Incrementador extends Thread {
	private Contador cont;
	public Incrementador(Contador cont) {
		this.cont = cont;
	}
	
	public void run() {
		System.out.println(this.getName() + " entrou...");
		cont.incrementa();
		System.out.println(this.getName() + " saiu...");
	}
}
