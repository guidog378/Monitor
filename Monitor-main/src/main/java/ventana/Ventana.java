package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import modeloSocket.Receptor;

import java.awt.GridLayout;
import java.awt.SystemColor;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JLabel box;
	private JLabel dni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					Thread miThreadReceptor = new Thread(new Receptor(frame.getDni(),frame.getBox()));
					miThreadReceptor.start();
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
	public Ventana() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Proximo Cliente:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(30);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Box:");
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		box = new JLabel("En Espera");
		panel_2.add(box);
		box.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(30);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_3.add(lblNewLabel_2);
		
		dni = new JLabel("En Espera");
		dni.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_3.add(dni);
	}

	public JLabel getBox() {
		return box;
	}

	public JLabel getDni() {
		return dni;
	}
}
