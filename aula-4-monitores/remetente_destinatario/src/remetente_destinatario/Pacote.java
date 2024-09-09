package remetente_destinatario;

public class Pacote {
	private String mensagem;
	private boolean sendoEnviado = true;
	
	public Pacote() {}
	
	public synchronized void enviar(String mensagem, String threadName) {
		// enquanto o pacote está sendo recebido
		while(!sendoEnviado) {
			try {
				// espero...
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		
		this.mensagem = mensagem;
		System.out.println("Mensagem " + "\"" + this.mensagem  + "\"" + " enviada pela " + threadName);
		this.sendoEnviado = false;
		notify();
	}
	
	public synchronized String receber() {
		// enquanto pacote está sendo enviado...
		while(sendoEnviado) {
			try {
				// espero...
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		
		System.out.println("Mensagem recebida: " + this.mensagem);
		
		this.sendoEnviado = true;
		notify();
		return this.mensagem;
	}
}
