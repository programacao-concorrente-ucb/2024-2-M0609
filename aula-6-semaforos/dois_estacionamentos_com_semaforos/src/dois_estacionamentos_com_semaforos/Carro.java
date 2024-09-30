package dois_estacionamentos_com_semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Carro extends Thread {
	private String nome;
	private Estacionamento estacionamento1, estacionamento2;
	
	public Carro(String nome, Estacionamento estacionamento1, Estacionamento estacionamento2) {
		super(nome);
		this.estacionamento1 = estacionamento1;
		this.estacionamento2 = estacionamento2;
	}
	
	public void esperar() throws InterruptedException {
		// valor aletório entre 10 e 20
		int randomSecs = new Random().nextInt(20) + 10;
		
		Thread.sleep(1000*randomSecs);
	}
	
	
	public void run() {
		try {
			System.out.println("Tamanho das fila do estacionamento 1: " + 
		estacionamento1.getSemaphore().getQueueLength());
			System.out.println("Tamanho das fila do estacionamento 2: " + 
		estacionamento2.getSemaphore().getQueueLength());

			Estacionamento estacionamentoComFilaMaisCurta = null;
			if(this.estacionamento1.getSemaphore().getQueueLength() < 
					this.estacionamento2.getSemaphore().getQueueLength()) {
				estacionamentoComFilaMaisCurta = this.estacionamento1;
			} else if(this.estacionamento1.getSemaphore().getQueueLength() >
			this.estacionamento2.getSemaphore().getQueueLength()) {
				estacionamentoComFilaMaisCurta = this.estacionamento2;
			} else {
				int estacionamentoAleatorio = new Random().nextInt(2) + 1;
				if(estacionamentoAleatorio == 1) {
					estacionamentoComFilaMaisCurta = this.estacionamento1;
				} else {
					estacionamentoComFilaMaisCurta = this.estacionamento2;
				}
				
			}
					
					

			System.out.println(this.getName() + " esperando para entrar no estacionamento " + estacionamentoComFilaMaisCurta.getNome() + "...");

			estacionamentoComFilaMaisCurta.getSemaphore().acquire();
			
			System.out.println(this.getName() + " entrou no estacionamento");
			
			this.esperar();
			
			System.out.println(this.getName() + " saiu do estacionamento");

			estacionamentoComFilaMaisCurta.getSemaphore().release();
			
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
		
	}
	
}
