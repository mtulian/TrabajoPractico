package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.*;

public class ElectrodomesticoAdapter {

	
	public ArrayList<Electrodomestico>  getall(){
		ArrayList<Electrodomestico> prueba = new ArrayList<Electrodomestico>();
	      
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
    		Electrodomestico e = new Electrodomestico(id,p,c,ce,pe);
    		prueba.add(e);
    		}
    	myconn.close();

        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
			}
		return prueba;
	}

}
