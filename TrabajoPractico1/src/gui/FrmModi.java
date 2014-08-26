package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import negocio.ElectrodomesticoLogic;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

public class FrmModi extends JDialog {
	private JTextField txtPrecioBase;
	private JTextField txtPeso;
	private JTextField txtCarga;
	private JTextField txtResolucion;
	private JLabel lblCarga;
	private JCheckBox cbxSintonizador;
	private JLabel lblResolucion;
	private JComboBox cbxColor;
	private JComboBox cbxConsumo;
	private JButton button;
	private JButton button_1;
	private Electrodomestico elec;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmModi dialog = new FrmModi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public void activaLava(boolean bool){
		lblCarga.setVisible(bool);
		txtCarga.setVisible(bool);
	}
	public void activaTele(boolean bool){
		lblResolucion.setVisible(bool);
		txtResolucion.setVisible(bool);
		cbxSintonizador.setVisible(bool);
	}	
	public void cargarForm(int id){
		elec = ElectrodomesticoLogic.getOne(id);
		txtPrecioBase.setText(String.valueOf(elec.getPrecioBase()));
		txtPeso.setText(String.valueOf(elec.getPeso()));
		cbxColor.setSelectedItem(elec.getColor());
		cbxConsumo.setSelectedItem(elec.getConsumoEnergético());
		if (elec instanceof Lavarropas) {
			txtCarga.setText(String.valueOf(((Lavarropas) elec).getCarga()));
			activaLava(true);
		}else if(elec instanceof Television){
			cbxSintonizador.setSelected(((Television) elec).isSintonizadorTDT());
			txtResolucion.setText(String.valueOf(((Television) elec).getResolucion()));
			activaTele(true);
		}
	}
	
	public FrmModi() {
		setModal(true);
		setBounds(100, 100, 450, 299);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 154);
		getContentPane().add(panel);
		panel.setLayout(null);
		{
			txtPrecioBase = new JTextField();
			txtPrecioBase.setBounds(83, 26, 117, 20);
			panel.add(txtPrecioBase);
			txtPrecioBase.setColumns(10);
		}
		//Codigo para centrarlo
		setLocationRelativeTo(null);
	    cbxColor = new JComboBox();
		cbxColor.setBounds(83, 57, 117, 20);
		panel.add(cbxColor);
		cbxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Rojo", "Azul", "Gris"}));
		
	    cbxConsumo = new JComboBox();
		cbxConsumo.setBounds(83, 88, 117, 20);
		panel.add(cbxConsumo);
		cbxConsumo.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		{
			txtPeso = new JTextField();
			txtPeso.setBounds(83, 119, 117, 20);
			panel.add(txtPeso);
			txtPeso.setColumns(10);
		}
		{
			JLabel lblPrecioBase = new JLabel("Precio base:");
			lblPrecioBase.setBounds(10, 32, 104, 14);
			panel.add(lblPrecioBase);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			lblColor.setBounds(10, 63, 46, 14);
			panel.add(lblColor);
		}
		{
			JLabel lblConsumo = new JLabel("Consumo:");
			lblConsumo.setBounds(10, 94, 56, 14);
			panel.add(lblConsumo);
		}
		{
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(10, 125, 56, 14);
			panel.add(lblPeso);
		}
		{
		    cbxSintonizador = new JCheckBox("Sintonizador");
			cbxSintonizador.setVisible(false);
			cbxSintonizador.setBounds(274, 52, 134, 30);
			panel.add(cbxSintonizador);
		}
		{
			txtCarga = new JTextField();
			txtCarga.setVisible(false);
			txtCarga.setColumns(10);
			txtCarga.setBounds(287, 26, 117, 20);
			panel.add(txtCarga);
		}
		{
			txtResolucion = new JTextField();
			txtResolucion.setVisible(false);
			txtResolucion.setColumns(10);
			txtResolucion.setBounds(287, 26, 117, 20);
			panel.add(txtResolucion);
		}
		{
			lblResolucion = new JLabel("Resoluci\u00F3n:");
			lblResolucion.setVisible(false);
			lblResolucion.setBounds(210, 29, 69, 14);
			panel.add(lblResolucion);
		}
		{
			lblCarga = new JLabel("Carga:");
			lblCarga.setVisible(false);
			lblCarga.setBounds(210, 29, 63, 14);
			panel.add(lblCarga);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 176, 414, 76);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		{
			button = new JButton("");
			button.setIcon(new ImageIcon(FrmModi.class.getResource("/recursos/Guardar.png")));
			button.setSelectedIcon(new ImageIcon(FrmModi.class.getResource("/recursos/Guardar.png")));
			button.setToolTipText("Guardar");
			button.setBounds(273, 11, 60, 56);
			panel_1.add(button);
			{
				button_1 = new JButton("");
				button_1.setIcon(new ImageIcon(FrmModi.class.getResource("/recursos/salir.png")));
				button_1.setToolTipText("Salir");
				button_1.setBounds(343, 11, 60, 56);
				panel_1.add(button_1);
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					elec.setPrecioBase(Float.parseFloat(txtPrecioBase.getText()));
					elec.setPeso(Float.parseFloat(txtPeso.getText()));
					elec.setColor((String)cbxColor.getSelectedItem());
					elec.setConsumoEnergetico((String)cbxConsumo.getSelectedItem());
					if (elec instanceof Lavarropas) {
						((Lavarropas) elec).setCarga(Float.parseFloat(txtCarga.getText()));
					}else if (elec instanceof Television) {
						((Television) elec).setResolucion(Float.parseFloat(txtResolucion.getText()));
						((Television) elec).setSintonizadorTDT(cbxSintonizador.isSelected());
					}
					ElectrodomesticoLogic.update(elec);
				dispose();
				}
			});
		}
	}
}
