package contador_com_monitor;

public class Main {
	public static void main(String args[]) {
		
		int numThreads = 10000;
		Incrementador incs[] = new Incrementador[numThreads];
		int exec = 1;
		while(true) {
			Contador cont = new Contador(0);
			System.out.println("Execução " + exec);
			for(int i = 0;i < numThreads;i++) {
				incs[i] = new Incrementador(cont);
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