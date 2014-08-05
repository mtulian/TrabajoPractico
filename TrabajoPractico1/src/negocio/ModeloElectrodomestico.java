package negocio;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import entidades.Electrodomestico;
//import Presentacion.frmPrincipal;
public class ModeloElectrodomestico extends AbstractTableModel{
		private static final long serialVersionUID = 1L;
		String[] encabezados = {"ID", "Precio Base","Color","Consumo","Peso"};//mismo nosmbres que la bd
		ArrayList<Electrodomestico> elec;
		@Override
		public int getColumnCount() {
			return encabezados.length;
		}
		public ModeloElectrodomestico(){
			//ventas = FrmPrincipal.ventas;
		}
		@Override
		public int getRowCount() {
			
			return elec.size();
		}

		@Override
		public Object getValueAt(int x, int y) {
			String retorno ="";
			Electrodomestico ele = elec.get(x);
			switch(y){
				case 0: retorno = String.valueOf(ele.getPrecioBase());
				break;
				case 1: retorno = String.valueOf(ele.getColor());
				break;
				case 2: retorno = String.valueOf(ele.getConsumoEnergético());
				break;
				case 3: retorno = String.valueOf(ele.getPeso());
				break;
	/*			case 4: {
					int cantidad = ele.getCantidad();
					double precio = elec.precioEntrada;
					precio = precio *cantidad;
					retorno = String.valueOf(precio);
					break;
				}*/
			}
			return retorno;
		}

		@Override
		public String getColumnName(int x) {
			
			return encabezados[x] ;
		}
	}
