package contador_com_locks;

public class Contador {
	private int x;
	
	Contador(int x){
		this.setX(x);
	}
	
	public void incrementa() {
		this.x++;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
