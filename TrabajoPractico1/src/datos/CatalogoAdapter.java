package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

public class CatalogoAdapter {
	//MÉTODOS DEL CATÁLOGO
	static ArrayList<Electrodomestico> elec = new ArrayList<Electrodomestico>();
	private int filasAfectadas;
	
	public static ArrayList<Electrodomestico> getAll(){
		
		if (elec.size() == 0) {
		Electrodomestico e1;
		//Televisores
		e1 = new Television(100, "Gris", "F", 40, 30, true);
		elec.add(e1);
		e1 = new Television(50, "Blanco", "A", 40, 25, false);
		elec.add(e1);
		//Lavarropas
		e1 = new Lavarropas(100, "Gris", "F", 30, 30);
		elec.add(e1);
		e1 = new Lavarropas(50, "Blanco", "A", 30, 25);
		elec.add(e1);
		return elec;
		}
		else {
			return elec;
		}
	}
	public void deleteOne(Electrodomestico e){
		elec.remove(e);
	}	
	public void deleteOne(int id){
		for (Electrodomestico electrodomestico : elec) {
			if (electrodomestico.getId() == id) {
				elec.remove(electrodomestico);
				break;
			}
		}
	}
	public void addOne(Electrodomestico e){
		elec.add(e);		
	}
	public Electrodomestico getOne(int ID)
	{
		for (Electrodomestico electrodomestico : elec) {
			if (electrodomestico.getId() == ID) {
				return electrodomestico;
			}
		}
		Electrodomestico elec = new Electrodomestico();
		return elec;
	}
	public void update(Electrodomestico e){
		elec.set(e.getId(), e);
	}
	public int getFilasAfectadas() {
		return filasAfectadas;
	}
	public void setFilasAfectadas(int filasAfectadas) {
		this.filasAfectadas = filasAfectadas;
	}
}
