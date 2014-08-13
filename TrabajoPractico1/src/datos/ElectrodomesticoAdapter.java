package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

public class ElectrodomesticoAdapter {
	static ArrayList<Electrodomestico> elec = new ArrayList<Electrodomestico>();
	
	public ArrayList<Television>  getallBD(){
		ArrayList<Television> prueba = new ArrayList<Television>();
	      
        try
        {
            Connection myconn = ConexionDB.GetConnection();
            
            Statement comando = myconn.createStatement();
    		ResultSet registro = comando.executeQuery("select * from electrodomestico");
    		while(registro.next())
    		{
    		int id = Integer.parseInt(registro.getString("ID_Elec"));
    		float p = Float.parseFloat(registro.getString("precioBase"));
    		String c = registro.getString("color");
    		String ce = registro.getString("consumoE");
    		float pe = Float.parseFloat(registro.getString("peso"));
    		//Television e = new Television(p,c,ce,pe); despues lo vemos
    		//prueba.add(e);
    		}
    	myconn.close();

        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
			}
		return prueba;
	}

	//metodo agregado
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
	public void addOne(Electrodomestico e){
		elec.add(e);
	}
	public void getOne(int ID){}
	public void update(int ID){}
}
