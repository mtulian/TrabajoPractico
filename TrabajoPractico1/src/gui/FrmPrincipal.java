package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setTitle("Venta de electrodomesticos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -26, 241, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Codigo para centrarlo
		setLocationRelativeTo(null);
		
		//codigo para sacar botones
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		//hasta ahí
		
		JButton btnAlta = new JButton("");
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
		
		JLabel lblOpciones = new JLabel("Menu");
		lblOpciones.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblOpciones.setBounds(34, 11, 99, 23);
		contentPane.add(lblOpciones);
		
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
		
		JButton btnUpdate = new JButton("");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*FrmModi formModi = new FrmModi();
				formModi.setVisible(true);*/
			}
		});
		btnUpdate.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/Modi.png")));
		btnUpdate.setBounds(34, 176, 177, 46);
		contentPane.add(btnUpdate);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		btnSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/recursos/salir.png")));
		btnSalir.setBounds(34, 233, 177, 46);
		contentPane.add(btnSalir);
	}
}
