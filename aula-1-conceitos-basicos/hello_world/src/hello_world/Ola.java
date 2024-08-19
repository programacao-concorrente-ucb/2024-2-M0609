package hello_world;

public class Ola extends Thread {
	private String personName;
	
	public Ola(String threadName, String personName) {
		super();
		this.setName(threadName);
		this.personName = personName;
	}
	
	String getPersonName() {
		return personName;
	}
	
	public void run() {
		System.out.println(this.getName() + " executando...");
		System.out.println("Olá, " + this.getPersonName());
	}
}
