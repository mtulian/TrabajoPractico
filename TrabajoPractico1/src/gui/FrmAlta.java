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

import java.awt.Toolkit;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import utilidades.Validacion;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setResizable(false);
		getContentPane().setBackground(SystemColor.controlHighlight);
		setTitle("Alta de electrodomesticos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAlta.class.getResource("/recursos/home.png")));
		setModal(true);
		setBounds(100, 100, 450, 315);
		getContentPane().setLayout(null);
		//Codigo para centrarlo
				setLocationRelativeTo(null);
		
		JPanel panelCampos = new JPanel();
		panelCampos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCampos.setBackground(SystemColor.control);
		panelCampos.setBounds(10, 11, 414, 177);
		getContentPane().add(panelCampos);
		panelCampos.setLayout(null);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validacion.soloAdmiteDigitos(e);
			}
		});
		txtPrecio.setBounds(89, 49, 117, 20);
		panelCampos.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio base:");
		lblPrecio.setBounds(10, 52, 86, 14);
		panelCampos.add(lblPrecio);
		
		cbxColor = new JComboBox();
		cbxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Rojo", "Azul", "Gris"}));
		cbxColor.setBounds(88, 80, 118, 20);
		panelCampos.add(cbxColor);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 83, 46, 14);
		panelCampos.add(lblColor);
		
		cbxConsumo = new JComboBox();
		cbxConsumo.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		cbxConsumo.setBounds(89, 111, 117, 20);
		panelCampos.add(cbxConsumo);
		
		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setBounds(10, 114, 59, 14);
		panelCampos.add(lblConsumo);
		
		txtPeso = new JTextField();
		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validacion.soloAdmiteDigitos(e);
			}
		});
		txtPeso.setBounds(89, 144, 117, 20);
		panelCampos.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 147, 46, 14);
		panelCampos.add(lblPeso);
		
		lblCarga = new JLabel("Carga:");
		lblCarga.setVisible(false);
		lblCarga.setBounds(216, 53, 46, 14);
		panelCampos.add(lblCarga);
		
		txtCarga = new JTextField();
		txtCarga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validacion.soloAdmiteDigitos(e);
			}
		});
		txtCarga.setVisible(false);
		txtCarga.setColumns(10);
		txtCarga.setBounds(286, 49, 117, 20);
		panelCampos.add(txtCarga);
		
		lblResolucion = new JLabel("Resoluci\u00F3n:");
		lblResolucion.setBounds(214, 52, 73, 14);
		panelCampos.add(lblResolucion);
		
		txtResolucion = new JTextField();
		txtResolucion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  char caracter = e.getKeyChar();
			      // Verificar si la tecla pulsada no es un digito
			      if(((caracter < '0') ||(caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/) && (caracter != ','))
			      {
			         e.consume();  // ignorar el evento de teclado
			      }	
			}
		});
		txtResolucion.setColumns(10);
		txtResolucion.setBounds(286, 49, 117, 20);
		panelCampos.add(txtResolucion);
		
		cbxSintonizador = new JCheckBox("Sintonizador");
		cbxSintonizador.setBounds(281, 76, 123, 30);
		panelCampos.add(cbxSintonizador);
		cbxTipo = new JComboBox();
		cbxTipo.setBounds(88, 16, 118, 20);
		panelCampos.add(cbxTipo);
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
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 21, 81, 14);
		panelCampos.add(lblTipo);
		
		panelBotones = new JPanel();
		panelBotones.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
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
				
				if(Validacion.camposVacios(txtPrecio.getText(),cbxColor.getSelectedItem(),cbxConsumo.getSelectedItem(),txtPeso.getText(),tipo, txtCarga.getText(),txtResolucion.getText() ))
				{
					
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
								ElectrodomesticoLogic.addOneBD(nuevoElectro);
							break;
								}
						default: {
							float res = Float.parseFloat(txtResolucion.getText());
							boolean sinto = cbxSintonizador.isSelected();
								Television nuevoElectro = new Television(p,c,ce,pe,res,sinto);
								ElectrodomesticoLogic.addOne(nuevoElectro);
								ElectrodomesticoLogic.addOneBD(nuevoElectro);
							break;
							}	
					}
					Limpiar();
				}
			
			}

		});
		
	}
}
