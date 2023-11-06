package filosofos;

public class Main {
	public static void main(String[] args) {
		Filosofo f0=new Filosofo(0);
		Filosofo f1=new Filosofo(1);
		Filosofo f2=new Filosofo(2);
		Filosofo f3=new Filosofo(3);
		Filosofo f4=new Filosofo(4);
		f0.start();
		f1.start();
		f2.start();
		f3.start();
		f4.start();
	}

}
