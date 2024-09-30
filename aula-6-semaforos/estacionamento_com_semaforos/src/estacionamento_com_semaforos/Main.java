package estacionamento_com_semaforos;

import java.util.concurrent.Semaphore;

public class Main {
	private static int NUM_VAGAS = 10;
	private static int NUM_CARROS = 20;
	
	public static void main(String[] args) {
		Semaphore estacionamento = new Semaphore(NUM_VAGAS);
		
		for(int i = 0;i < NUM_CARROS;i++) {
			new Carro("carro " + (i+1), estacionamento).start();
		}

	}

}
