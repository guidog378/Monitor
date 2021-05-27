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

import componentesVista.tablaClientes;
import comunicacion.Conexion;
import modelo.EscuchaClientesAtendidos;

import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private tablaClientes modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					Conexion conexion = new Conexion();
					Thread miThreadReceptor = new Thread(new EscuchaClientesAtendidos(frame,conexion));
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
		
		JLabel lblNewLabel = new JLabel("Cartelera de turnos:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		modeloTabla = new tablaClientes();
		table = new JTable(modeloTabla);
		scrollPane.setViewportView(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		table.setFillsViewportHeight(true);
	}

	public tablaClientes getModeloTabla() {
		return modeloTabla;
	}

	public JTable getTable() {
		return table;
	}
	
}
