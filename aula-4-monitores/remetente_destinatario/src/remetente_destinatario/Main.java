package remetente_destinatario;

public class Main {
	public static void main(String[] args) {
		String[] mensagens1 = {
				"primeira mensagem",
				"segunda mensagem",
				"Olá MUNDO!",
				"última mensagem",
				"FIM"
		};
		
		String[] mensagens2 = {
				"fala",
				"zeze",
				"FIM"
		};
		
		
		Pacote pacote = new Pacote();
		
		Remetente remetente1 = new Remetente(pacote, mensagens1);
		Remetente remetente2 = new Remetente(pacote, mensagens2);

		Destinatario destinatario = new Destinatario(pacote, 2);
		
		remetente1.start();
		remetente2.start();
		destinatario.start();
		
	}
}
