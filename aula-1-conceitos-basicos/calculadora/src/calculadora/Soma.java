package calculadora;

public class Soma extends Thread {
	private int a;
	private int b;
	
	public Soma(int a, int b) {
		this.setA(a);
		this.setB(b);
	}
	
	public void run() {
		System.out.println("Calculando a + b...");
		System.out.println("a + b = " + (a + b));
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}
