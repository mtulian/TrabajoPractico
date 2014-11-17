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
	
	Connection myconn = ConexionDB.getInstancia().getConn();
	Statement comando;
	ResultSet registro;
	String query =null;
	PreparedStatement preStmt;
	private int filasAfectadas;
	public int getFilasAfectadas() {
		return filasAfectadas;
	}
	public void setFilasAfectadas(int filasAfectadas) {
		this.filasAfectadas = filasAfectadas;
	}
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
			
			/*
			try{
				if(registro!=null){registro.close();}
				if(myconn!=null && !myconn.isClosed()){myconn.close();}
				ConexionDB.getInstancia().getConn().close();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
			*/
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
			
			/*
			try{
				if(rs!=null){rs.close();}
				if(myconn!=null && !myconn.isClosed()){myconn.close();}
				ConexionDB.getInstancia().CloseConn();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}*/
			
		}
		return elec;
	}
	public void addOneBD(Electrodomestico elec){
		
		String sql="insert into electrodomestico(precioBase,color,consumoEnergetico,peso,resolucion,sintonizador,carga) values (?,?,?,?,?,?,?)";
		PreparedStatement sentencia=null;

		Connection conn= ConexionDB.getInstancia().getConn();

		try {

			sentencia= (PreparedStatement) myconn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//sentencia.setInt(1, elec.getId());
			sentencia= (PreparedStatement) conn.prepareStatement(sql);
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
			//ResultSet cps= sentencia.getGeneratedKeys();
			//if(cps.next()){
			//	int elecID=cps.getInt(1);
			//	elec.setId(elecID);
			//}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			
			/*
			try{
				if(myconn!=null && !myconn.isClosed()){myconn.close();}
				ConexionDB.getInstancia().CloseConn();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
			*/
			
		}
	}
	public void updateOneBD(Electrodomestico e){	
		String sql="update electrodomestico set precioBase=?, color=?, consumoEnergetico=?, peso=?, resolucion=?, sintonizador=?, carga=? where id=?";
		PreparedStatement sentencia=null;
		Connection conn= ConexionDB.getInstancia().getConn();
		try
        {
        	int id = e.getId();
        	float pb = e.getPrecioBase();
        	String col = e.getColor();
        	String con = e.getConsumoEnergético();
        	float pes = e.getPeso();
        	preStmt = (PreparedStatement) conn.prepareStatement(sql);
    		preStmt.setFloat(1, pb);
    		preStmt.setString(2, col);
    		preStmt.setString(3, con);
    		preStmt.setFloat(4, pes);
    		preStmt.setInt(8, id);  
        	if(e instanceof Lavarropas){
        		float car = ((Lavarropas) e).getCarga();
        		preStmt.setFloat(5, 0);
        		preStmt.setFloat(6, 0);
        		preStmt.setFloat(7, car);	  		
        	}
        	else if (e instanceof Television){
        		float res = ((Television) e).getResolucion();
        		boolean sin = ((Television)e).isSintonizadorTDT();
        		preStmt.setFloat(5, res);
        		preStmt.setBoolean(6, sin);  
        		preStmt.setFloat(7, 0); 
        	}
        	preStmt.executeUpdate();
    		//liberaRecursosBD();
        }
		catch(SQLException sqle){
			sqle.printStackTrace();
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
		
		/*
		try{
			if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
			ConexionDB.getInstancia().CloseConn();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		*/
		
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
	//Fin metodos de base datos
}
