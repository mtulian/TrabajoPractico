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

import negocio.ElectrodomesticoL;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

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
	private int tipo=0; // {0-Electrodomestico, 1-Television, 2-Lavarropa}
	private JComboBox cbxColor;
	private JComboBox cbxConsumo;
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
	//Va a servir para verificar que los campos esten todos ingresados
	//En el caso de que alguno no se halla ingresado abra que mostrar un cartel
	//Que diga tal campo debe ser ingresado
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		//Codigo para centrarlo
				setLocationRelativeTo(null);
		cbxTipo = new JComboBox();
		cbxTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Limpiar();
				String eleccion = (String)cbxTipo.getSelectedItem();
				switch(eleccion){
				case "Electrodomestico": {activaLava(false);activaTele(false); tipo = 0;  break;}
				case "Lavarropa":  {activaLava(true);activaTele(false); tipo = 1; break;}
				case "Television": {activaLava(false);activaTele(true); tipo = 2; break;}
				default: break;
				}
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Electrodomestico", "Television", "Lavarropa"}));
		cbxTipo.setBounds(78, 14, 139, 20);
		getContentPane().add(cbxTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 17, 81, 14);
		getContentPane().add(lblTipo);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(10, 45, 414, 206);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(89, 14, 117, 20);
		panelPrincipal.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio base:");
		lblPrecio.setBounds(10, 17, 86, 14);
		panelPrincipal.add(lblPrecio);
		
		cbxColor = new JComboBox();
		cbxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Rojo", "Azul", "Gris"}));
		cbxColor.setBounds(88, 45, 118, 20);
		panelPrincipal.add(cbxColor);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 48, 46, 14);
		panelPrincipal.add(lblColor);
		
		cbxConsumo = new JComboBox();
		cbxConsumo.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		cbxConsumo.setBounds(89, 76, 117, 20);
		panelPrincipal.add(cbxConsumo);
		
		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setBounds(10, 79, 59, 14);
		panelPrincipal.add(lblConsumo);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(89, 109, 117, 20);
		panelPrincipal.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 112, 46, 14);
		panelPrincipal.add(lblPeso);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Electrodomestico nuevoElectro;
				float p = Float.parseFloat(txtPrecio.getText());
				String c = (String)cbxColor.getSelectedItem();
				String ce = (String)cbxConsumo.getSelectedItem();
				float pe = Float.parseFloat(txtPeso.getText());
				switch(tipo)
				{
					//float p,String c,char ce,float pe,float carga
					case 1:{ float carga = Float.parseFloat(txtCarga.getText());
					nuevoElectro = new Lavarropas(p,c,ce,pe,carga); 
					break;
							}
					//float p,String c,char ce,float pe,float res,boolean sinto
					case 2:{ float res = Float.parseFloat(txtResolucion.getText());
					 boolean sinto = cbxSintonizador.isSelected();
					 nuevoElectro = new Television(p,c,ce,pe,res,sinto);
					 break;
							}
					//float p,String c,char ce,float pe,
					default:{nuevoElectro = new Electrodomestico(p,c,ce,pe); break;}
				}
						
				ElectrodomesticoL.getLista().add(nuevoElectro);
				Limpiar();
				
			}

		});
		btnGuardar.setBounds(216, 172, 89, 23);
		panelPrincipal.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnSalir.setBounds(315, 172, 89, 23);
		panelPrincipal.add(btnSalir);
		
		lblCarga = new JLabel("Carga:");
		lblCarga.setVisible(false);
		lblCarga.setBounds(216, 17, 46, 14);
		panelPrincipal.add(lblCarga);
		
		txtCarga = new JTextField();
		txtCarga.setVisible(false);
		txtCarga.setColumns(10);
		txtCarga.setBounds(287, 14, 117, 20);
		panelPrincipal.add(txtCarga);
		
		lblResolucion = new JLabel("Resoluci\u00F3n:");
		lblResolucion.setVisible(false);
		lblResolucion.setBounds(216, 17, 73, 14);
		panelPrincipal.add(lblResolucion);
		
		txtResolucion = new JTextField();
		txtResolucion.setVisible(false);
		txtResolucion.setColumns(10);
		txtResolucion.setBounds(287, 14, 117, 20);
		panelPrincipal.add(txtResolucion);
		
		cbxSintonizador = new JCheckBox("Sintonizador");
		cbxSintonizador.setVisible(false);
		cbxSintonizador.setBounds(270, 40, 134, 30);
		panelPrincipal.add(cbxSintonizador);
		
	}
}
