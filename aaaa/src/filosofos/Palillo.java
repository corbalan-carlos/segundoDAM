package filosofos;

import java.util.concurrent.Semaphore;

class Palillo {
	static boolean ready=false;
	static Semaphore[] palillos=new Semaphore[5];
	static void init() {
		for (int i=0;i<5;i++) {
			palillos[i]=new Semaphore(1);
		}
		ready=true;
	}
}