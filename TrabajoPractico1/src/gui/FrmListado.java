package gui;

import java.awt.BorderLayout;

import javax.swing.table.*;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;

import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import entidades.Electrodomestico;
import negocio.ModeloElectrodomestico;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import negocio.*;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
public class FrmListado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblElectrodomesticos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmListado dialog = new FrmListado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void listado(){
		tblElectrodomesticos.setModel(new ModeloElectrodomestico());
	}
	/**
	 * Create the dialog.
	 */
	public FrmListado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmListado.class.getResource("/recursos/home.png")));
		setTitle("Listado de electrodomesticos");
		setModal(true);
		setBounds(100, 100, 634, 333);
		getContentPane().setLayout(null);
		
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setBounds(10, 11, 598, 197);
		getContentPane().add(panelTabla);
		
		
		tblElectrodomesticos = new JTable();
		tblElectrodomesticos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelTabla.setViewportView(tblElectrodomesticos);
		ModeloElectrodomestico model = new ModeloElectrodomestico();
		TableRowSorter sorter = new TableRowSorter(model);
		tblElectrodomesticos.setModel(model);
		tblElectrodomesticos.setRowSorter(sorter);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 219, 598, 65);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setIcon(new ImageIcon(FrmListado.class.getResource("/recursos/salir.png")));
		btnSalir.setBounds(536, 11, 52, 52);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setActionCommand("OK");
		//Codigo para centrarlo
		setLocationRelativeTo(null);
		JButton btnEliminar = new JButton("");
		btnEliminar.setToolTipText("Eliminar");
		btnEliminar.setBounds(474, 11, 52, 52);
		panel.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				int filaselec = tblElectrodomesticos.getSelectedRow();
				if (filaselec != -1) 
				{	
					int rta = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el electrodomestico seleccionado?", "Aviso", JOptionPane.YES_NO_OPTION);
					if(rta == 0) // Cambiar por Result del JOptionPane.
					{
						
				
							int id = (int) tblElectrodomesticos.getValueAt(filaselec, 0);
							ElectrodomesticoLogic.deleteOne(id);
							listado();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No hay electrodomesticos seleccionados", "Aviso", JOptionPane.INFORMATION_MESSAGE );
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(FrmListado.class.getResource("/recursos/Baja.png")));
		
		JButton btnModi = new JButton("");
		btnModi.setToolTipText("Modificar");
		btnModi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmModi formulario = new FrmModi();
				formulario.setVisible(true);
			}
		});
		btnModi.setBounds(412, 11, 52, 52);
		panel.add(btnModi);
		btnModi.setIcon(new ImageIcon(FrmListado.class.getResource("/recursos/Modi.png")));

	}
}
