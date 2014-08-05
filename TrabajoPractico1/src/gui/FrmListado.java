package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.JLabel;

import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import negocio.ElectrodomesticoL;
import negocio.ModeloElectrodomestico;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmListado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblElectrodomesticos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmListado dialog = new FrmListado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmListado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmListado.class.getResource("/recursos/home.png")));
		setTitle("Listado de electrodomesticos");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setActionCommand("OK");
			btnSalir.setBounds(345, 5, 79, 23);
			buttonPane.add(btnSalir);
		}
		
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setBounds(10, 11, 414, 207);
		getContentPane().add(panelTabla);
		
		tblElectrodomesticos = new JTable();
		panelTabla.setViewportView(tblElectrodomesticos);
		tblElectrodomesticos.setModel(new ModeloElectrodomestico());
	}
}
