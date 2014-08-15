package gui;

import java.awt.BorderLayout;

import javax.swing.table.*;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 608, 55);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setActionCommand("OK");
			btnSalir.setBounds(529, 21, 79, 23);
			buttonPane.add(btnSalir);
			
			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listado();
				}
			});
			btnListar.setActionCommand("OK");
			btnListar.setBounds(440, 21, 79, 23);
			buttonPane.add(btnListar);
		}
		
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setBounds(10, 11, 598, 207);
		getContentPane().add(panelTabla);
		
		
		tblElectrodomesticos = new JTable();
		panelTabla.setViewportView(tblElectrodomesticos);
		ModeloElectrodomestico model = new ModeloElectrodomestico();
		TableRowSorter sorter = new TableRowSorter(model);
		tblElectrodomesticos.setModel(model);
		tblElectrodomesticos.setRowSorter(sorter);

	}
}
