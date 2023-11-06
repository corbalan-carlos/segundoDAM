package restaurante;


public class Sincro {
	private int b=0; 
	public synchronized void a() {
		if (b++>=Restaurante.MAX_MESAS-1) {
			this.notifyAll();
		} else {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized static void print(String a) {
		System.out.print(a);
	}
	
}	
