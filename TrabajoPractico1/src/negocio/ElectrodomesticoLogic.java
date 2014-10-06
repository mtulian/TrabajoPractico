package negocio;

import java.util.ArrayList;

import datos.*;
import entidades.*;

public class ElectrodomesticoLogic {
	
	static ElectrodomesticoAdapter adap = new ElectrodomesticoAdapter();
	
	//BD
	public static Electrodomestico getOneBD(int id){
		return adap.getOneBD(id);
	}	
	public static void deleteOneBD(int id){
		adap.deleteOneBD(id);
	}
	public static void addOneBD(Electrodomestico e){
		adap.addOneBD(e);
	}
	public static void updateOneDB(Electrodomestico e){
		adap.updateOneBD(e);
	}
	public static ArrayList<Electrodomestico> getallBD(){
		return adap.getAllBD();
	}
	
	//Colecciones
	public static void addOne(Electrodomestico e){
		adap.addOne(e);
	}
	public static void deleteOne(Electrodomestico e){
		adap.deleteOne(e);
	}
	public static void deleteOne(int id){
		adap.deleteOne(id);
	}
	public static void update(Electrodomestico e){
		adap.update(e);
	}
	public static ArrayList<Electrodomestico> getall(){
		return ElectrodomesticoAdapter.getAll();
	}
	public static Electrodomestico getOne(int id){
		return adap.getOne(id);
	}
	
	
}
