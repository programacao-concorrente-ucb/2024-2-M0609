package contador_com_try_lock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
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
		boolean adquiriuTrava = false;
		try {
			System.out.println(this.getName() + " esperando trava ser liberada...");
			adquiriuTrava = this.trava.tryLock(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("Erro: Thread interrompida!");
		}
		
		if(adquiriuTrava) {
			System.out.println(this.getName() + " adquiriu a trava...");
			cont.incrementa();
			System.out.println(this.getName() + " incrementando o contador...");
			int numAleatorioMilisec = ThreadLocalRandom.
					current().nextInt(2000, 4000);
			this.wait(numAleatorioMilisec);
			
			System.out.println(this.getName() + " liberando a trava...");
			this.trava.unlock();	
		} else {
			System.out.println(this.getName() + " não conseguiu adquirir a trava...");
		}

	}
}