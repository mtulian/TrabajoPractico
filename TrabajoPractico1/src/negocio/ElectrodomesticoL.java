package negocio;
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

	
}
