package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entidades.*;

public class ModeloElectrodomestico implements TableModel{
	//public List<Electrodomestico> elec = ElectrodomesticoL.getLista();
	//Para coneccion a bd
	//public List<Electrodomestico> elec = ElectrodomesticoL.getall();
	public List<Electrodomestico> elec = new ElectrodomesticoL().getLista();
	public List<String> nombreColumnas = new ArrayList<String>();
	public List<TableModelListener> tableModelListeners = new ArrayList<TableModelListener>();
	public ModeloElectrodomestico() {
		nombreColumnas.add("ID");
		nombreColumnas.add("Precio Base");
		nombreColumnas.add("Color");
		nombreColumnas.add("Consumo");
		nombreColumnas.add("Peso");
		//Columnas que faltarian apra que se agreguen todos los atributos
		//nombreColumnas.add("Carga");
		//nombreColumnas.add("Resolucion");
		//nombreColumnas.add("Sintonizador");		
	}
	@Override
	public Class<?> getColumnClass(int arg0) {
		return getValueAt(0, arg0).getClass();
	}

	@Override
	public int getColumnCount() {
		if(nombreColumnas!=null){
			return nombreColumnas.size();
		}
		return 0;
	}

	@Override
	public String getColumnName(int arg0) {
		if(nombreColumnas!=null && arg0>=0 && nombreColumnas.size()>arg0){
			return nombreColumnas.get(arg0);
		}
		return null;
	}

	@Override
	public int getRowCount() {
		if(elec!=null){
			return elec.size();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(elec!=null && arg0>=0 && arg1>=0 && elec.size()>arg0){
			Electrodomestico e = elec.get(arg0);
			switch(arg1){
				case 0: return e.getId();
				case 1: return e.getPrecioBase();
				case 2: return e.getColor();
				case 3: return e.getConsumoEnergético();
				case 4: return e.getPeso();
				//case 5: return ((Television) e).getResolucion();
				//case 6: return ((Television) e).isSintonizadorTDT();
				//case 7: return ((Lavarropas) e).getCarga();
			}
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		tableModelListeners.remove(arg0);
	}
	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		tableModelListeners.remove(arg0);
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}