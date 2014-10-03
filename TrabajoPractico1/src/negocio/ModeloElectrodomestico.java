package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

public class ModeloElectrodomestico implements TableModel{
	//public ArrayList<Electrodomestico> elec = ElectrodomesticoLogic.getall();
	
	public ArrayList<Electrodomestico> elec = ElectrodomesticoLogic.getallBD();
	public List<String> nombreColumnas = new ArrayList<String>();
	public List<TableModelListener> tableModelListeners = new ArrayList<TableModelListener>();
	public ModeloElectrodomestico() {
		nombreColumnas.add("ID");
		nombreColumnas.add("Precio Base");
		nombreColumnas.add("Color");
		nombreColumnas.add("Consumo");
		nombreColumnas.add("Peso");
		nombreColumnas.add("Resolucion");
		nombreColumnas.add("Sintonizador");	
		nombreColumnas.add("Carga");
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
		if(elec !=null){
			return elec.size();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(elec !=null && arg0>=0 && arg1>=0 && elec.size()>arg0)
		{
			Electrodomestico e = elec.get(arg0);
			switch(arg1)
			{
				case 0: return e.getId(); 
				case 1: return e.getPrecioBase();
				case 2: return e.getColor();
				case 3: return e.getConsumoEnergético();
				case 4: return e.getPeso();
				case 5: if (e instanceof Television) 
						{
							return ((Television) e).getResolucion();
						}
						else {
							return 0;
							}
				case 6:if (e instanceof Television) 
				{
					return ((Television) e).isSintonizadorTDT();
				}
				else {
					return false;
					}
				case 7:if (e instanceof Lavarropas) 
				{
					return ((Lavarropas) e).getCarga();
				}
				else {
					return 0;
					}
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
		/*
		if(elec!=null && arg1>=0 && arg2>=0 && elec.size()>arg1){
			Electrodomestico electrodomestico= elec.get(arg1);
			switch(arg2){
				case 0:
					Integer codigoNuevo=null;
					if(arg0!=null){
						codigoNuevo=(Integer)arg0;
					}
					electrodomestico.setId(codigoNuevo);
					break;
				case 1: float precioNuevo=0;
					if ((float)arg0!= 0) {
						precioNuevo = (float)arg0;
					}
					electrodomestico.setPrecioBase(precioNuevo);
					break;
				case 2: String ColorNuevo = null;
				if (arg0!= null) {
					ColorNuevo = (String)arg0;
				}
				electrodomestico.setColor(ColorNuevo);
				break;
				case 3: String ConsumoNuevo = null;
				if (arg0!= null) {
					ConsumoNuevo = (String)arg0;
				}
				electrodomestico.setConsumoEnergetico(ConsumoNuevo);
				break;
				case 4: float pesoNuevo=0;
				if ((float)arg0!= 0) {
					pesoNuevo = (float)arg0;
				}
				electrodomestico.setPrecioBase(pesoNuevo);
				break;
				case 5: break;
				case 6: break;
				case 7: break;
				
				
			}
		}*/
	}
}