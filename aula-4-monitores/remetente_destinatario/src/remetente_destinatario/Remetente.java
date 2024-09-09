package remetente_destinatario;

import java.util.concurrent.ThreadLocalRandom;

public class Remetente extends Thread {
	private Pacote pacote;
	private String[] mensagens;
	
	public Remetente(Pacote pacote, String[] mensagens) {
		this.pacote = pacote;
		this.mensagens = mensagens;
	}
	
	public void run() {
		for(String mensagem: this.mensagens) {
			this.pacote.enviar(mensagem, this.getName());
			
			// gera um valor entre 2 e 5 s
			int numAleatorioMilisec = ThreadLocalRandom.
					current().nextInt(2000, 5000);
			
			try {
				Thread.sleep(numAleatorioMilisec);
			} catch(Exception e) {
				System.out.println("Erro:" + e);
			}
		}
		System.out.println(this.getName() + " foi encerrada!");
	}
	
}
