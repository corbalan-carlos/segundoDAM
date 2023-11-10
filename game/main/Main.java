import topos.vista1.*;
import java.awt.Color;
public class Main {
	public static void main(String[] args) {
		Pantalla p=new Pantalla(11,11,50,Color.BLACK);
		for (int i=0;i<11;i++) {
			for (int j=0;j<11;j++) {
				p.addImagen(i,j, "imagenes/panel-basico.gif");
			}
		}
		p.dibujar();
	}

}
