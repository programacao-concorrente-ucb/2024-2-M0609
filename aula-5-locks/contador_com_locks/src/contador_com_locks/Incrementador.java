package contador_com_locks;

import java.util.concurrent.locks.Lock;

public class Incrementador extends Thread {
	private Contador cont;
	private Lock trava;
	
	public Incrementador(Contador cont, Lock trava) {
		this.cont = cont;
		this.trava = trava;
	}
	
	public void wait(int numMilliSesc) {
		try {
			Thread.sleep(numMilliSesc);
		} catch(Exception e) {
			System.out.println("Erro:" + e);
		}
	}
	
	
	public void run() {
		System.out.println(this.getName() + " esperando trava ser liberada...");
		this.trava.lock();
		System.out.println(this.getName() + " adquiriu a trava...");
		cont.incrementa();
		System.out.println(this.getName() + " incrementando o contador...");
		this.wait(10000);
		System.out.println(this.getName() + " liberou a trava...");
		this.trava.unlock();
	}
}