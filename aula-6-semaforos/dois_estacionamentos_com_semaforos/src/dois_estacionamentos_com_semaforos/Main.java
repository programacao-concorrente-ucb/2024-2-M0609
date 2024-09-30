package dois_estacionamentos_com_semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
	private static int NUM_VAGAS = 2;
	private static int NUM_CARROS = 50;
	
	public static void main(String[] args) throws InterruptedException {
		Estacionamento estacionamento1 = new Estacionamento("Estacionamento 1", new Semaphore(NUM_VAGAS));
		Estacionamento estacionamento2 = new Estacionamento("Estacionamento 2", new Semaphore(NUM_VAGAS));

		for(int i = 0;i < NUM_CARROS;i++) {
			new Carro("carro " + (i+1), estacionamento1, estacionamento2).start();
			// valor aletório entre 10 e 20
			int randomSecs = new Random().nextInt(5) + 1;
			
			Thread.sleep(1000*randomSecs);
		}

	}

}