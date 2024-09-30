package estacionamento_com_semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Carro extends Thread {
	private String nome;
	private Semaphore estacionamento;
	
	public Carro(String nome, Semaphore estacionamento) {
		super(nome);
		this.estacionamento = estacionamento;
	}
	
	public void esperar() throws InterruptedException {
		// valor aletório entre 10 e 20
		int randomSecs = new Random().nextInt(20) + 10;
		
		Thread.sleep(1000*randomSecs);
	}
	
	
	public void run() {
		try {
			System.out.println(this.getName() + " esperando para entrar no estacionamento...");
			this.estacionamento.acquire();
			
			System.out.println(this.getName() + " entrou no estacionamento");
			
			this.esperar();
			
			System.out.println(this.getName() + " saiu do estacionamento");

			this.estacionamento.release();
			
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
		
	}
	
}
