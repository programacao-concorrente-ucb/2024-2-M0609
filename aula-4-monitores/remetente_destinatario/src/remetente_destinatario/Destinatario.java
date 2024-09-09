package remetente_destinatario;

import java.util.concurrent.ThreadLocalRandom;

public class Destinatario extends Thread {
	private Pacote pacote;
	private int numRemetentes;
	
	public Destinatario(Pacote pacote, int numRemetentes) {
		this.pacote = pacote;
		this.numRemetentes = numRemetentes;
	}
	
	public void run() {
		while(true) {
			String mensagem = pacote.receber();
			
			// quando devo sair do while(true)?
			// quando o remetente não tiver mais mensagens
			if(mensagem.equals("FIM")) {
				this.numRemetentes--;
				if(numRemetentes == 0) {
					break;
				}
			}
			
			
			// gera um valor entre 2 e 5 s
			int numAleatorioMilisec = ThreadLocalRandom.
					current().nextInt(2000, 5000);
			
			try {
				Thread.sleep(numAleatorioMilisec);
			} catch(Exception e) {
				System.out.println("Erro:" + e);
			}
		}
	}
	
}
