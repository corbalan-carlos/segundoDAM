package restaurante;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.Semaphore;

public class Mesa extends Thread {
	static Sincro sincro=new Sincro();
	private int id;
	private Pipe.SinkChannel p;
	private ByteBuffer buffer;
	static Semaphore s=new Semaphore(Restaurante.MAX_COCINEROS);
	private static int n=0; 
	@Override
	public void run() {
		sincro.a();
		while (true) {
			if (s.tryAcquire()) {
				try {
					Thread.sleep((int)(Math.random()*2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.release();
				if (n==1) {
					try {
						p.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				n--;
				return;
			} else {
				try {
					Thread.sleep((int)(Math.random()*1000));
					buffer.put(	(("Mesa " + id + " esperando cocinero\n").getBytes()));
					buffer.flip();
					try {
						p.write(buffer);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					buffer.clear();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	Mesa(int id) {
		this.p=Restaurante.p.sink();
		this.id=id;
		this.buffer=ByteBuffer.allocate(100);
		n++;
	}
	
	
}
