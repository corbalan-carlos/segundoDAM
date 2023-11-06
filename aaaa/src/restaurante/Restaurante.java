package restaurante;

import java.io.IOException;
import java.nio.channels.Pipe;
import java.time.Instant;

public class Restaurante  {
	public static final int MAX_MESAS=100;
	public static final int MAX_COCINEROS=8;
	public static Pipe p;
	public static Metre metre;
	public static long epoch;
	public volatile static boolean a=false;
	static public void main(String[] args) {
		epoch=Instant.now().getEpochSecond();
		try {
			p=Pipe.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
		metre=new Metre(false);
		Mesa[] arr=new Mesa[MAX_MESAS];
		Sincro.print(Instant.now().toString()+"\n");
		metre.start();
		for (int i=0;i<MAX_MESAS;i++) {
			arr[i]=new Mesa(i);
			arr[i].start();
		}
		
		try {
			metre.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sincro.print("Simulacion terminada a las "+Instant.now().toString()+"\n");
		Sincro.print("Tiempo total de simulacion "+ (Instant.now().getEpochSecond()-epoch) +" segundos \n");
		
	}
	
}
