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
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
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
		setResizable(false);
		getContentPane().setBackground(SystemColor.controlHighlight);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmListado.class.getResource("/recursos/home.png")));
		setTitle("Listado de electrodomesticos");
		setModal(true);
		setBounds(100, 100, 624, 323);
		getContentPane().setLayout(null);
		
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		panelTabla.setBounds(10, 11, 598, 197);
		getContentPane().add(panelTabla);
		
		
		tblElectrodomesticos = new JTable();
		tblElectrodomesticos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelTabla.setViewportView(tblElectrodomesticos);
		ModeloElectrodomestico model = new ModeloElectrodomestico();
		TableRowSorter sorter = new TableRowSorter(model);
		tblElectrodomesticos.setModel(model);
		tblElectrodomesticos.setRowSorter(sorter);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelBotones.setBounds(10, 219, 598, 65);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(null);
		
		JButton btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setIcon(new ImageIcon(FrmListado.class.getResource("/recursos/salir.png")));
		btnSalir.setBounds(536, 7, 52, 52);
		panelBotones.add(btnSalir);
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
		btnEliminar.setBounds(468, 7, 52, 52);
		panelBotones.add(btnEliminar);
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
				int filaselec = tblElectrodomesticos.getSelectedRow();
				if (filaselec != -1) 
				{	
				FrmModi formulario = new FrmModi();
				formulario.cargarForm((int)tblElectrodomesticos.getValueAt(filaselec,0));
				formulario.setVisible(true);
				listado();
				}
				else {
					JOptionPane.showMessageDialog(null, "No hay electrodomesticos seleccionados", "Aviso", JOptionPane.INFORMATION_MESSAGE );
				}
			}
		});
		btnModi.setBounds(399, 7, 52, 52);
		panelBotones.add(btnModi);
		btnModi.setIcon(new ImageIcon(FrmListado.class.getResource("/recursos/modificar.png")));

	}
}
