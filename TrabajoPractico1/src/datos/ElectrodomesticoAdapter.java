package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

public class ElectrodomesticoAdapter {
	
	static ArrayList<Electrodomestico> elec = new ArrayList<Electrodomestico>();
	
	Connection myconn;
	Statement comando;
	ResultSet registro;
	String query =null;
	PreparedStatement preStmt;

	private int filasAfectadas;
	
	
	//MÉTODOS DE LA BASE DE DATOS
	
	public ArrayList<Electrodomestico> getAllBD(){
		ArrayList<Electrodomestico> prueba = new ArrayList<Electrodomestico>();     
		
		String sql="select * from electrodomestico";
		Statement sentencia=null;
		ResultSet rs =null;
		try {			
			sentencia= ConexionDB.getInstancia().getConn().createStatement();
			rs= sentencia.executeQuery(sql);
			
			while(rs.next()){
				Electrodomestico elec;
				if(rs.getFloat("carga") != 0)
					elec = new Lavarropas(rs.getInt("id"),rs.getFloat("precioBase"),rs.getString("color"),rs.getString("consumoEnergetico"),rs.getFloat("peso"),rs.getFloat("carga"));
				//int id,float p,String c,String ce,float pe,float carga
				else {
				//int id,float p,String c,String ce,float pe,float res,boolean sinto
					elec = new Television(rs.getInt("id"),rs.getFloat("precioBase"),rs.getString("color"),rs.getString("consumoEnergetico"),rs.getFloat("peso"),rs.getFloat("resolucion"),rs.getBoolean("sintonizador"));
				}	
	    		prueba.add(elec);
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(registro!=null){registro.close();}
				if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
				ConexionDB.getInstancia().getConn().close();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
		
		return prueba;
	}
	public Electrodomestico getOneBD(int id){

		String sql="select * from electrodomestico where id=?";
	
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Electrodomestico elec=null;
		
		try {			
			sentencia= (PreparedStatement) ConexionDB.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, id);
			rs= sentencia.executeQuery();
			
			if(rs.next()){
				if(rs.getFloat("carga") != 0)
					elec = new Lavarropas(rs.getInt("id"),rs.getFloat("precioBase"),rs.getString("color"),rs.getString("consumoEnergetico"),rs.getFloat("peso"),rs.getFloat("carga"));
				//int id,float p,String c,String ce,float pe,float carga
				else {
				//int id,float p,String c,String ce,float pe,float res,boolean sinto
					elec = new Television(rs.getInt("id"),rs.getFloat("precioBase"),rs.getString("color"),rs.getString("consumoEnergetico"),rs.getFloat("peso"),rs.getFloat("resolucion"),rs.getBoolean("sintonizador"));
				}		
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){rs.close();}
				if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
				ConexionDB.getInstancia().CloseConn();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return elec;
	}
	
	public void addOneBD(Electrodomestico elec){
		
		String sql="insert into electrodomestico(precioBase,color,consumoEnergetico,peso,resolucion,sintonizador,carga) values (?,?,?,?,?,?,?)";
		PreparedStatement sentencia=null;
		Connection conn= ConexionDB.getInstancia().getConn();
		
		try {
			sentencia= (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//sentencia.setInt(1, elec.getId());
			sentencia.setFloat(1, elec.getPrecioBase());
			sentencia.setString(2, elec.getColor());
			sentencia.setString(3, elec.getConsumoEnergético());
			sentencia.setFloat(4, elec.getPeso());
			if (elec instanceof Lavarropas) {
				sentencia.setFloat(5, 0);
				sentencia.setBoolean(6, false);
				sentencia.setFloat(7, ((Lavarropas) elec).getCarga());
			}
			else {
				sentencia.setFloat(5, ((Television) elec).getResolucion());
				sentencia.setBoolean(6,((Television) elec).isSintonizadorTDT());
				sentencia.setFloat(7, 0);
			}
			
			setFilasAfectadas(sentencia.executeUpdate());
			ResultSet cps= sentencia.getGeneratedKeys();
			if(cps.next()){
				int elecID=cps.getInt(1);
				elec.setId(elecID);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
				ConexionDB.getInstancia().CloseConn();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
	}

	/*
	public void deleteOneBD(int id){
        try
        {
        	preStmt = (PreparedStatement) myconn.prepareStatement("DELETE * FROM ELECTRODOMESTICO WHERE id=?");
        	preStmt.setInt(1, id);
        	preStmt.execute();
    		liberaRecursosBD();
        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}*/
	public void updateOneBD(Electrodomestico e){	
        try
        {
        	int id = e.getId();
        	float pb = e.getPrecioBase();
        	String col = e.getColor();
        	String con = e.getConsumoEnergético();
        	float pes = e.getPeso();
        	if(e instanceof Lavarropas){
        		float car = ((Lavarropas) e).getCarga();
        		preStmt = (PreparedStatement) myconn.prepareStatement("UPDATE ELECTRODOMESTICO SET(precioBase=?, color=?, consumoEnergético=?, peso=?, resolucion=?, sintonizador=?, carga=?) WHERE id=?");
        		preStmt.setFloat(1, pb);
        		preStmt.setString(2, col);
        		preStmt.setString(3, con);
        		preStmt.setFloat(4, pes);
        		preStmt.setFloat(5, 0);
        		preStmt.setFloat(6, 0);
        		preStmt.setFloat(7, car);
            	preStmt.setInt(8, id);    		
        	}
        	else if (e instanceof Television){
        		float res = ((Television) e).getResolucion();
        		boolean sin = ((Television)e).isSintonizadorTDT();
        		preStmt = (PreparedStatement) myconn.prepareStatement("UPDATE ELECTRODOMESTICO SET(precioBase=?, color=?, consumoEnergético=?, peso=?, resolucion=?, sintonizador=?, carga=?) WHERE id=?");
        		preStmt.setFloat(1, pb);
        		preStmt.setString(2, col);
        		preStmt.setString(3, con);
        		preStmt.setFloat(4, pes);
        		preStmt.setFloat(5, res);
        		preStmt.setBoolean(6, sin);  
        		preStmt.setFloat(7, 0);
            	preStmt.setInt(8, id);  
        	}
        	preStmt.execute();
    		liberaRecursosBD();
        }
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}	
	public void liberaRecursosBD(){
		try{
			if(registro != null)
				registro.close();
			if(comando != null)
				comando.close();
			if(myconn != null)
				myconn.close();
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
	}
	
	
	public void deleteOneBD(int id){
	
	String sql="delete from electrodomestico where id=?";
	PreparedStatement sentencia=null;
	int i;
	try {			
		sentencia= (PreparedStatement) ConexionDB.getInstancia().getConn().prepareStatement(sql);
		sentencia.setInt(1, id);
		i = sentencia.executeUpdate();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		try{
			if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
			ConexionDB.getInstancia().CloseConn();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	/*try
    {
		registro = comando.executeQuery("DELETE * FROM ELECTRODOMESTICO WHERE id=id");
		liberaRecursosBD();
    }
	catch(SQLException sqle){
		System.out.println(sqle.getMessage());
	}*/
}
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
		public int getFilasAfectadas() {
			return filasAfectadas;
		}
		public void setFilasAfectadas(int filasAfectadas) {
			this.filasAfectadas = filasAfectadas;
		}
}
