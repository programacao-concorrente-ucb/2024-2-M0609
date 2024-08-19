package calculadora;

public class Main {
	public static void main(String args[]) {
		System.out.println("Executando a main...");
		Soma soma = new Soma(10, 20);
		Soma soma1 = new Soma(1, 4);
		Soma soma2 = new Soma(100, 32);
		Soma soma3 = new Soma(-10, 10);
		soma.start();
		soma1.start();
		soma2.start();
		soma3.start();
	}
}
