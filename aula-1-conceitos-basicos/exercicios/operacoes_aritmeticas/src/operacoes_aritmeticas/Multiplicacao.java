package operacoes_aritmeticas;

public class Multiplicacao extends Thread {
	private Integer valor1, valor2;
	
	public Multiplicacao(Integer valor1, Integer valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	public void run() {
		Integer sub = this.valor1 * this.valor2;
		System.out.println(this.valor1 + " * " + this.valor2 + " = " + sub);
	}
}
