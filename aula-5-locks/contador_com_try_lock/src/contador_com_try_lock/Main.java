package contador_com_try_lock;
import java.util.concurrent.locks.*;


public class Main {
	public static void main(String args[]) {
		Contador cont = new Contador(0);
		Lock trava = new ReentrantLock();
		int numThreads = 10;
		Incrementador incs[] = new Incrementador[numThreads];
		for(int i = 0;i < numThreads;i++) {
			incs[i] = new Incrementador(cont, trava);
			incs[i].start();
			//System.out.println("thread " + i + " inicializada");
		}
		
		try {
			for(int i = 0;i < numThreads;i++) {
				incs[i].join();
			}
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		
		System.out.println("Valor final do contador: " + cont.getX());
	}
}