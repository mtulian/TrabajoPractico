package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import java.awt.Color;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setTitle("Venta de electrodomesticos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -26, 241, 276);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Codigo para centrarlo
		setLocationRelativeTo(null);
		
		//codigo para sacar botones
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		//hasta ahí
		
		JButton btnAlta = new JButton("");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmAlta formAlta = new FrmAlta();
				formAlta.setVisible(true);
			}
		});
		btnAlta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/Alta.png")));
		btnAlta.setBounds(34, 45, 177, 46);
		contentPane.add(btnAlta);
		
		JButton btnListado = new JButton("");
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmListado formList = new FrmListado();
				formList.setVisible(true);
			}
		});
		btnListado.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/lista.png")));
		btnListado.setBounds(34, 114, 177, 46);
		contentPane.add(btnListado);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rta = JOptionPane.showConfirmDialog(null, "Desea cerrar la aplicación?", "Aviso", JOptionPane.YES_NO_OPTION);
			if(rta == 0)
			 {
				System.exit(0);
			 }
			}
		});
		btnSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/salir.png")));
		btnSalir.setBounds(34, 187, 177, 46);
		contentPane.add(btnSalir);
	}
}
