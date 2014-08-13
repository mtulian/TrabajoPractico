package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.ElectrodomesticoLogic;
import entidades.Electrodomestico;
import entidades.Television;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmBaja extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox cbxCodigo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmBaja dialog = new FrmBaja();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public FrmBaja() {
		setTitle("Baja de electrodomesticos");
		setModal(true);
		setBounds(100, 100, 309, 140);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setBounds(10, 30, 69, 14);
		getContentPane().add(lblNewLabel);
		//Codigo para centrarlo
				setLocationRelativeTo(null);
				
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cbxCodigo.removeItem(cbxCodigo.getSelectedItem());
			ElectrodomesticoLogic.deleteOne((Electrodomestico)cbxCodigo.getSelectedItem());

			}
		});
		btnEliminar.setBounds(95, 71, 89, 23);
		getContentPane().add(btnEliminar);
		
		ArrayList<Electrodomestico> elec = ElectrodomesticoLogic.getall();
		cbxCodigo = new JComboBox();
		//String[] asd = {"ID","precio","color","consumo","peso"};
		//cbxCodigo.addItem(asd);
		for (Electrodomestico electro : elec) {
			cbxCodigo.addItem(electro);
		}
		
		cbxCodigo.setBounds(89, 26, 194, 23);
		getContentPane().add(cbxCodigo);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(194, 71, 89, 23);
		getContentPane().add(btnSalir);
	}
}
