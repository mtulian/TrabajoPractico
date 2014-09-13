package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Splash extends JFrame {

	private JPanel contentPane;
	JLabel fondoFrame;
	JProgressBar Progreso;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
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
	public Splash() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -26, 241, 276);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Progreso = new JProgressBar();
		Progreso.setForeground(SystemColor.activeCaption);
		Progreso.setBorder(new LineBorder(new Color(0, 0, 0)));
		Progreso.setIndeterminate(true);
		Progreso.setBackground(Color.WHITE);
		Progreso.setBounds(48, 232, 146, 14);
		contentPane.add(Progreso);
		this.setLocationRelativeTo(null);
		setVisible(true);
		
		fondoFrame = new JLabel(new ImageIcon(Splash.class.getResource("/recursos/Splash.png")));
		fondoFrame.setBorder(new LineBorder(new Color(0, 0, 0)));
		fondoFrame.setBounds(0, 0, 241, 276);
		contentPane.add(fondoFrame);

		new Thread()
		{
			public void run()
			{
				/*
				for(int i=0; i<=100;i++)
				{
					try {
						sleep(70);
						Progreso.setValue(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
				try {
					sleep(10000);
					Cerrar();
					//SE INSTANCIA EL MENÚ
					//
					//
					//
					//
					//SE PONE EN VISIBLE
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}.start();
						
	}
	
	private void Cerrar()
	{
		this.setVisible(false);
	}
}
