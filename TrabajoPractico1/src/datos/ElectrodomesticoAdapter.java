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
	
	Connection myconn;
	Statement comando;
	ResultSet registro;
	
	//MÉTODOS DEL CATÁLOGO
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
	
	//MÉTODOS DE LA BASE DE DATOS
	/*
	public Electrodomestico getOneBD(int id){
		
	}
	*/
	public ArrayList<Electrodomestico> getAllBD(){
		ArrayList<Electrodomestico> prueba = new ArrayList<Electrodomestico>();
	      
        try
        {
            myconn = ConexionDB.GetConnection();
            comando = myconn.createStatement();
    		registro = comando.executeQuery("SELECT * FROM ELECTRODOMESTICO");
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
    	
    	liberaRecursosBD();

        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
			}
		return prueba;
	}
	public void addOneBD(Electrodomestico e){
        try
        {
        	String query =null;
        	float pb = e.getPrecioBase();
        	String col = e.getColor();
        	String con = e.getConsumoEnergético();
        	float pes = e.getPeso();
        	if(e instanceof Lavarropas){
        		float car = ((Lavarropas) e).getCarga();
        		query = "INSERT INTO ELECTRODOMESTICO (precioBase, color, consumoEnergetico, peso, carga) VALUES (pb, col, con, pes, car)";
        	}
        	else if (e instanceof Television){
        		float res = ((Television) e).getResolucion();
        		boolean sin = ((Television)e).isSintonizadorTDT();
        		query = "INSERT INTO ELECTRODOMESTICO (precioBase, color, consumoEnergetico, peso, resolucion, sintonizador) VALUES (pb, col, con, pes, res, sin)";
        	}
        	registro = comando.executeQuery(query);
    		liberaRecursosBD();
        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}
	public void deleteOneBD(int id){
        try
        {
    		registro = comando.executeQuery("DELETE * FROM ELECTRODOMESTICO WHERE id=id");
    		liberaRecursosBD();
        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}
	public void updateOneBD(Electrodomestico e){	
        try
        {
    		registro = comando.executeQuery("UPDATE ELECTRODOMESTICO SET() WHERE id=id");
    		liberaRecursosBD();
        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}	
	public void liberaRecursosBD(){
		try{
			
			registro.close();
			comando.close();
			myconn.close();
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}
}
