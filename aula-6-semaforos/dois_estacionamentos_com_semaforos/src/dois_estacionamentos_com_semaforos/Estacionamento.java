package dois_estacionamentos_com_semaforos;

import java.util.concurrent.Semaphore;

public class Estacionamento {
	private Semaphore estacionamento;
	private String nome;
	
	public Estacionamento(String nome, Semaphore estacionamento){
		this.setNome(nome);
		this.setSemaphore(estacionamento);
	}

	public Semaphore getSemaphore() {
		return estacionamento;
	}

	public void setSemaphore(Semaphore estacionamento) {
		this.estacionamento = estacionamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
