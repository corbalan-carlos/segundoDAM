package instituto;
/*
 * Clase que representa una tabla de la BD
 */
public class Table {
	//Nombre de la tabla
	public String name;
	//Tipos de las columnas
	protected  int[] types;
	//Numero de columnas
	protected int nColumns;
	//Nombre de las colummnas
	protected String[] columnNames;
	//Constructor
	Table(String name, int[] types, int nColumns, String[] columnNames) {
		this.name=name;
		this.types=types.clone();
		this.nColumns=nColumns;
		this.columnNames=columnNames.clone();
	}
	@Override
	public String toString() {
		return "Table Name: "+ name+"\n"+ "Number of columns: "+ nColumns+"\n";
				
	}
}
