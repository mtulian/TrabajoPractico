package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmConfig extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmConfig dialog = new FrmConfig();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmConfig() {
		setBackground(SystemColor.controlHighlight);
		setModal(true);
		setUndecorated(true);
		setBounds(-8, -26, 241, 341);
		
		//Codigo para centrarlo
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelOpciones.setBounds(15, 11, 216, 267);
		contentPanel.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		JRadioButton rdCatalogo = new JRadioButton("Cat\u00E1logo");
		rdCatalogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdCatalogo.setSelected(true);
		rdCatalogo.setBounds(56, 58, 109, 23);
		panelOpciones.add(rdCatalogo);
		
		JRadioButton rdBD = new JRadioButton("Base de datos");
		rdBD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdBD.setBounds(56, 97, 109, 23);
		panelOpciones.add(rdBD);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdCatalogo);
		grupo.add(rdBD);
		
		JPanel panelAceptar = new JPanel();
		panelAceptar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelAceptar.setBounds(15, 286, 216, 44);
		contentPanel.add(panelAceptar);
		panelAceptar.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Visible(false);
			}
		});
		btnAceptar.setBounds(97, 11, 109, 23);
		panelAceptar.add(btnAceptar);
	}
	
	public void Visible(boolean visible)
	{
		this.setVisible(visible);
	}
}
