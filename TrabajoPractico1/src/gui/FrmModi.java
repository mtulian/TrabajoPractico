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

import java.awt.Toolkit;
import java.awt.SystemColor;

import javax.swing.border.LineBorder;

import utilidades.Validacion;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JButton btnGuardar;
	private JButton btnSalir;
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
		setResizable(false);
		getContentPane().setBackground(SystemColor.controlHighlight);
		setTitle("Modifaci\u00F3n de electrodomesticos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmModi.class.getResource("/recursos/home.png")));
		setModal(true);
		setBounds(100, 100, 440, 290);
		getContentPane().setLayout(null);
		JPanel panelCampos = new JPanel();
		panelCampos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCampos.setBounds(10, 11, 414, 154);
		getContentPane().add(panelCampos);
		panelCampos.setLayout(null);
		{
			txtPrecioBase = new JTextField();
			txtPrecioBase.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					   Validacion.soloAdmiteDigitos(e);		      
				}
			});
			txtPrecioBase.setBounds(83, 26, 117, 20);
			panelCampos.add(txtPrecioBase);
			txtPrecioBase.setColumns(10);
		}
		//Codigo para centrarlo
		setLocationRelativeTo(null);
	    cbxColor = new JComboBox();
		cbxColor.setBounds(83, 57, 117, 20);
		panelCampos.add(cbxColor);
		cbxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Rojo", "Azul", "Gris"}));
		
	    cbxConsumo = new JComboBox();
		cbxConsumo.setBounds(83, 88, 117, 20);
		panelCampos.add(cbxConsumo);
		cbxConsumo.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		{
			txtPeso = new JTextField();
			txtPeso.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					   Validacion.soloAdmiteDigitos(e);
				}
			});
			txtPeso.setBounds(83, 119, 117, 20);
			panelCampos.add(txtPeso);
			txtPeso.setColumns(10);
		}
		{
			JLabel lblPrecioBase = new JLabel("Precio base:");
			lblPrecioBase.setBounds(10, 32, 104, 14);
			panelCampos.add(lblPrecioBase);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			lblColor.setBounds(10, 63, 46, 14);
			panelCampos.add(lblColor);
		}
		{
			JLabel lblConsumo = new JLabel("Consumo:");
			lblConsumo.setBounds(10, 94, 56, 14);
			panelCampos.add(lblConsumo);
		}
		{
			JLabel lblPeso = new JLabel("Peso:");
			lblPeso.setBounds(10, 125, 56, 14);
			panelCampos.add(lblPeso);
		}
		{
		    cbxSintonizador = new JCheckBox("Sintonizador");
			cbxSintonizador.setVisible(false);
			cbxSintonizador.setBounds(287, 52, 109, 30);
			panelCampos.add(cbxSintonizador);
		}
		{
			txtCarga = new JTextField();
			txtCarga.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					   Validacion.soloAdmiteDigitos(e);
				}
			});
			txtCarga.setVisible(false);
			txtCarga.setColumns(10);
			txtCarga.setBounds(287, 26, 117, 20);
			panelCampos.add(txtCarga);
		}
		{
			txtResolucion = new JTextField();
			txtResolucion.setVisible(false);
			txtResolucion.setColumns(10);
			txtResolucion.setBounds(287, 26, 117, 20);
			panelCampos.add(txtResolucion);
		}
		{
			lblResolucion = new JLabel("Resoluci\u00F3n:");
			lblResolucion.setVisible(false);
			lblResolucion.setBounds(210, 29, 69, 14);
			panelCampos.add(lblResolucion);
		}
		{
			lblCarga = new JLabel("Carga:");
			lblCarga.setVisible(false);
			lblCarga.setBounds(210, 29, 63, 14);
			panelCampos.add(lblCarga);
		}
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelBotones.setBounds(10, 176, 414, 76);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(null);
		{
			btnGuardar = new JButton("");
			btnGuardar.setIcon(new ImageIcon(FrmModi.class.getResource("/recursos/Guardar.png")));
			btnGuardar.setSelectedIcon(new ImageIcon(FrmModi.class.getResource("/recursos/Guardar.png")));
			btnGuardar.setToolTipText("Guardar");
			btnGuardar.setBounds(273, 11, 60, 56);
			panelBotones.add(btnGuardar);
			{
				btnSalir = new JButton("");
				btnSalir.setIcon(new ImageIcon(FrmModi.class.getResource("/recursos/salir.png")));
				btnSalir.setToolTipText("Salir");
				btnSalir.setBounds(343, 11, 60, 56);
				panelBotones.add(btnSalir);
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
			btnGuardar.addActionListener(new ActionListener() {
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
