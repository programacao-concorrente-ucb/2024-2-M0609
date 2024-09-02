package contador;

public class Main {
	public static void main(String args[]) {
		Contador cont = new Contador(0);
		int numThreads = 10000;
		Incrementador incs[] = new Incrementador[numThreads];
		for(int i = 0;i < numThreads;i++) {
			incs[i] = new Incrementador(cont);
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
