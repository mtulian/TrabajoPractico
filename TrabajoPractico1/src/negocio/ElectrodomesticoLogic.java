package negocio;

import java.util.ArrayList;

import datos.*;
import entidades.*;

public class ElectrodomesticoLogic {
	
	static ElectrodomesticoAdapter adap = new ElectrodomesticoAdapter();
	static CatalogoAdapter adapC = new CatalogoAdapter();
	
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
		adapC.addOne(e);
	}
	public static void deleteOne(Electrodomestico e){
		adapC.deleteOne(e);
	}
	public static void deleteOne(int id){
		adapC.deleteOne(id);
	}
	public static void update(Electrodomestico e){
		adapC.update(e);
	}
	public static ArrayList<Electrodomestico> getall(){
		return CatalogoAdapter.getAll();
	}
	public static Electrodomestico getOne(int id){
		return adapC.getOne(id);
	}
	
	
}
