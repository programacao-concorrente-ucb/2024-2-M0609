package contador_com_locks;
import java.util.concurrent.locks.*;

public class Main2 {
	public static void main(String args[]) {
		
		int numThreads = 10000;
		Incrementador incs[] = new Incrementador[numThreads];
		int exec = 1;
		while(true) {
			Contador cont = new Contador(0);
			Lock trava = new ReentrantLock();
			System.out.println("Execução " + exec);
			for(int i = 0;i < numThreads;i++) {
				incs[i] = new Incrementador(cont, trava);
				incs[i].start();
			}
			
			try {
				for(int i = 0;i < numThreads;i++) {
					incs[i].join();
				}
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
			
			if(cont.getX() != numThreads) {
				System.out.println("Valor final do contador: " + cont.getX());
				break;
			}
			exec++;
		}
		
	}
}
