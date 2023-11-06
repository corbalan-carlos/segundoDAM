package restaurante;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.time.Instant;

public class Metre extends Thread {
	private Pipe.SourceChannel p;
	private ByteBuffer buffer;
	
	@Override
	public void run() {
		while (Thread.activeCount()==2);
		while (Thread.activeCount()>2) {
			try {
				while(p.read(buffer)>0) {
					buffer.flip();
					StringBuilder printable=new StringBuilder();
					while (buffer.hasRemaining()) {
						printable.append((char)buffer.get());
					}
					Sincro.print(printable.toString());
					buffer.clear();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	Metre(boolean wakeable) {
		buffer=ByteBuffer.allocate(100);
		this.p=Restaurante.p.source();
	}
	
	
}
 