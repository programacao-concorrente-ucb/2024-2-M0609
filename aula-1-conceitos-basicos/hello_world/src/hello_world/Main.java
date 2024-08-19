package hello_world;

public class Main {
	public static void main(String args[]) {
		System.out.println("Executando main...");
		Ola threadOla = new Ola("Thread-João", "João");
		Ola threadOla2 = new Ola("Thread-Maria", "Maria");
		Ola threadOla3 = new Ola("Thread-Pedro", "Pedro");
		threadOla.start();
		threadOla2.start();
		threadOla3.start();
		System.out.println("Acabou a main!");
	}
}
