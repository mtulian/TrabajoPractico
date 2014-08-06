package negocio;
import datos.*;

import java.util.ArrayList;

import entidades.Electrodomestico;
public class ElectrodomesticoL {
	
	static ArrayList<Electrodomestico> lista = new ArrayList<Electrodomestico>();

	public static ArrayList<Electrodomestico> getLista() {
		return lista;
	}

	public static void setLista(ArrayList<Electrodomestico> lista) {
		ElectrodomesticoL.lista = lista;
	}
	public static ArrayList<Electrodomestico> getall(){
		ArrayList<Electrodomestico> elec = new ElectrodomesticoAdapter().getall();
		return elec;
	}
	
}

