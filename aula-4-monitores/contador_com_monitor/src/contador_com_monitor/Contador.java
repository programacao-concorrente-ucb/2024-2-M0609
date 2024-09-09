package contador_com_monitor;

public class Contador {
	private int x;
	
	Contador(int x){
		this.setX(x);
	}
	
	public synchronized void incrementa() {
		this.x++;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
