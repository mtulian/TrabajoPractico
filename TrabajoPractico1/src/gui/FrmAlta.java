package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.ElectrodomesticoLogic;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;
import javax.swing.ImageIcon;

public class FrmAlta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPrecio;
	private JTextField txtPeso;
	private JTextField txtCarga;
	private JTextField txtResolucion;
	private JComboBox cbxTipo;
	private JLabel lblCarga;
	private JCheckBox cbxSintonizador;
	private JLabel lblResolucion;
	private JComboBox cbxColor;
	private JComboBox cbxConsumo;
	private JPanel panelBotones;
	private int tipo= 0; // {0-Television, 1-Lavarropa}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmAlta dialog = new FrmAlta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	/*
	 * Region de métodos
	 */
	//0-Electrodomestico 1- Lavarropa 2-Television
	public void activaLava(boolean bool){
		lblCarga.setVisible(bool);
		txtCarga.setVisible(bool);
	}
	public void activaTele(boolean bool){
		lblResolucion.setVisible(bool);
		txtResolucion.setVisible(bool);
		cbxSintonizador.setVisible(bool);
	}	
	private void Limpiar() {
		txtPrecio.setText("");
		txtPeso.setText("");
		cbxColor.setSelectedIndex(-1);
		cbxConsumo.setSelectedIndex(-1);
		txtCarga.setText("");
		txtResolucion.setText("");
		cbxSintonizador.setSelected(false);
	}
	private void arrancar(boolean bool){
		txtPeso.setEnabled(bool);
		txtPrecio.setEnabled(bool);
		cbxColor.setEnabled(bool);;
		cbxConsumo.setEnabled(bool);;
	}
	//Va a servir para verificar que los campos esten todos ingresados
	//En el caso de que alguno no se halla ingresado abra que mostrar un cartel
	//Que diga tal campo debe ser ingresado
	//falta implementar
	public void valida(int i){
		switch(i){
		case 1:break;
		case 2:break;
		default: break;
		}
	}
	/*
	 * Fin region metodos
	 */
	public FrmAlta() {
		setModal(true);
		setBounds(100, 100, 450, 315);
		getContentPane().setLayout(null);
		//Codigo para centrarlo
				setLocationRelativeTo(null);
		cbxTipo = new JComboBox();
		cbxTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Limpiar();
				arrancar(true);
				String eleccion = (String)cbxTipo.getSelectedItem();
				switch(eleccion){
				case "Lavarropa":  {activaLava(true);activaTele(false); tipo = 1; break;}
				case "Television": {activaLava(false);activaTele(true); tipo = 0; break;}
				default: 
					break;//Falta un mensaje que diga tiene que seleccionar una opción
				}
			}
		});
		//"Electrodomestico"
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Television", "Lavarropa"}));
		cbxTipo.setBounds(78, 14, 139, 20);
		getContentPane().add(cbxTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 17, 81, 14);
		getContentPane().add(lblTipo);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(10, 45, 414, 143);
		getContentPane().add(panelInfo);
		panelInfo.setLayout(null);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(89, 14, 117, 20);
		panelInfo.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio base:");
		lblPrecio.setBounds(10, 17, 86, 14);
		panelInfo.add(lblPrecio);
		
		cbxColor = new JComboBox();
		cbxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Rojo", "Azul", "Gris"}));
		cbxColor.setBounds(88, 45, 118, 20);
		panelInfo.add(cbxColor);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 48, 46, 14);
		panelInfo.add(lblColor);
		
		cbxConsumo = new JComboBox();
		cbxConsumo.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		cbxConsumo.setBounds(89, 76, 117, 20);
		panelInfo.add(cbxConsumo);
		
		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setBounds(10, 79, 59, 14);
		panelInfo.add(lblConsumo);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(89, 109, 117, 20);
		panelInfo.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 112, 46, 14);
		panelInfo.add(lblPeso);
		
		lblCarga = new JLabel("Carga:");
		lblCarga.setVisible(false);
		lblCarga.setBounds(216, 17, 46, 14);
		panelInfo.add(lblCarga);
		
		txtCarga = new JTextField();
		txtCarga.setVisible(false);
		txtCarga.setColumns(10);
		txtCarga.setBounds(287, 14, 117, 20);
		panelInfo.add(txtCarga);
		
		lblResolucion = new JLabel("Resoluci\u00F3n:");
		lblResolucion.setBounds(216, 17, 73, 14);
		panelInfo.add(lblResolucion);
		
		txtResolucion = new JTextField();
		txtResolucion.setColumns(10);
		txtResolucion.setBounds(287, 14, 117, 20);
		panelInfo.add(txtResolucion);
		
		cbxSintonizador = new JCheckBox("Sintonizador");
		cbxSintonizador.setBounds(270, 40, 134, 30);
		panelInfo.add(cbxSintonizador);
		
		panelBotones = new JPanel();
		panelBotones.setBounds(10, 196, 414, 70);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(null);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(FrmAlta.class.getResource("/recursos/Guardar.png")));
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setBounds(267, 11, 62, 48);
		panelBotones.add(btnGuardar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setIcon(new ImageIcon(FrmAlta.class.getResource("/recursos/salir.png")));
		btnSalir.setBounds(339, 11, 65, 48);
		panelBotones.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				float p = Float.parseFloat(txtPrecio.getText());
				String c = (String)cbxColor.getSelectedItem();
				String ce = (String)cbxConsumo.getSelectedItem();
				float pe = Float.parseFloat(txtPeso.getText());
				switch(tipo)
				{
					case 1:{ 
						float carga = Float.parseFloat(txtCarga.getText());
						Lavarropas nuevoElectro = new Lavarropas(p,c,ce,pe,carga); 
						ElectrodomesticoLogic.addOne(nuevoElectro);
						break;
							}
					default: {
						float res = Float.parseFloat(txtResolucion.getText());
						boolean sinto = cbxSintonizador.isSelected();
						Television nuevoElectro = new Television(p,c,ce,pe,res,sinto);
						ElectrodomesticoLogic.addOne(nuevoElectro);
						break;
						}	
				}
				Limpiar();
				
			}

		});
		
	}
}
