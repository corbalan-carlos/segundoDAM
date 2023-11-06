package filosofos;

public class Filosofo extends Thread {
	private int id;
	int palilloDerecho;
	int palilloIzquierdo;
	private int state;
	@Override
	public void run() {
		while (true ) {
			if (state==-1) return;
			int rnd=(int) (Math.random()*10);
			if (rnd%2==0) {
				think(rnd);
			} else {
				eat();
			}
		}
	}
	void think(int a) {
		try {
			System.out.print("El filosofo "+id+" está pensando\n");
			Thread.sleep(a*100);
		} catch (InterruptedException e) {
			this.state=-1;
		}
	}
	void eat( ) {
		while (true) {
			boolean i=false;
			boolean d=false;
			if (Palillo.palillos[palilloIzquierdo].tryAcquire()) i=true; 
			if (Palillo.palillos[palilloDerecho].tryAcquire()) d=true;
			if (i&&d) {
				System.out.print("El filosofo "+id+" está comiendo\n");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					this.state=-1;
				}
				Palillo.palillos[palilloIzquierdo].release();
				Palillo.palillos[palilloDerecho].release();
				break;
			} else {
				if (i) Palillo.palillos[palilloIzquierdo].release();
				if (d) Palillo.palillos[palilloDerecho].release();
			}
		}
	}
	Filosofo(int a) {
		if (!Palillo.ready) {
			Palillo.init();
		}
		this.id=a;
		palilloDerecho=id;
		palilloIzquierdo=(id+1)%5;
	}
}