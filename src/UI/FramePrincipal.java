package UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Arista;
import Logica.Vertice;

public class FramePrincipal {

	private JFrame frame;
	private JTextField inputArista;
	private JTextField inputAristaDerecha;
	private JTextField inputExtremoIzquierdo;
	private DefaultTableModel model_verVertices;

	private Vertice _vertices ;
	private ArrayList<Arista> _arista;
	private JTable tableVerVertices;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FramePrincipal() {
		_vertices = new Vertice();
		_arista = new ArrayList<Arista>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1016, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Algoritmos Golosos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(359, 11, 243, 33);
		frame.getContentPane().add(lblNewLabel);

		// *********** PANEL AGREGAR VERTICES **************

		JPanel panelAgregarVertices = new JPanel();
		panelAgregarVertices.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelAgregarVertices.setBounds(108, 87, 308, 322);
		frame.getContentPane().add(panelAgregarVertices);
		panelAgregarVertices.setLayout(null);

		JLabel lblAgregarVertices = new JLabel("Agregar Vertices");
		lblAgregarVertices.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblAgregarVertices.setBounds(161, 54, 207, 33);
		frame.getContentPane().add(lblAgregarVertices);

		JButton btnAgregarVertice = new JButton("Agregar Vertice");
		btnAgregarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// AGREGAMOS VERTICES
				_vertices.agregarVertice(Integer.parseInt(inputArista.getText()));
				inputArista.setText("");
			}
		});

		btnAgregarVertice.setBounds(171, 80, 113, 26);
		panelAgregarVertices.add(btnAgregarVertice);

		// --------

		JLabel lblNewLabel_1 = new JLabel("Vertice");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(135, 127, 53, 23);
		panelAgregarVertices.add(lblNewLabel_1);

		inputArista = new JTextField();
		inputArista.setBounds(21, 79, 126, 29);
		panelAgregarVertices.add(inputArista);
		inputArista.setColumns(10);

		// --------

		JLabel lblNewLabel_1_2 = new JLabel("Extremo Derecho");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1_2.setBounds(34, 161, 100, 14);
		panelAgregarVertices.add(lblNewLabel_1_2);

		inputAristaDerecha = new JTextField();
		inputAristaDerecha.setBounds(31, 186, 253, 29);
		panelAgregarVertices.add(inputAristaDerecha);
		inputAristaDerecha.setColumns(10);

		// --------

		inputExtremoIzquierdo = new JTextField();
		inputExtremoIzquierdo.setBounds(33, 248, 253, 29);
		panelAgregarVertices.add(inputExtremoIzquierdo);
		inputExtremoIzquierdo.setColumns(10);

		JLabel lblNewLabel_1_2_1 = new JLabel("Extremo Izquierdo");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1_2_1.setBounds(31, 223, 120, 14);
		panelAgregarVertices.add(lblNewLabel_1_2_1);

		// --------

		JButton btnAgregarAlGrafo = new JButton("Relacionar Vertices");
		btnAgregarAlGrafo.setBackground(new Color(0, 255, 64));
		btnAgregarAlGrafo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgregarAlGrafo.setBounds(34, 288, 176, 23);
		btnAgregarAlGrafo.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		panelAgregarVertices.add(btnAgregarAlGrafo);

		JLabel lblNewLabel_1_3 = new JLabel("Vertice");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(67, 50, 53, 23);
		panelAgregarVertices.add(lblNewLabel_1_3);

		// ***************** FIN PANEL AGREGAR VERTICES *************

		// ***************** PANEL CONJUNTO MINIMO DOMINANTE *************

		JPanel panelConjuntoMinimoDominante = new JPanel();
		panelConjuntoMinimoDominante.setBackground(new Color(255, 234, 159));
		panelConjuntoMinimoDominante.setBorder(new LineBorder(new Color(255, 128, 64)));
		panelConjuntoMinimoDominante.setBounds(716, 87, 263, 322);
		frame.getContentPane().add(panelConjuntoMinimoDominante);

		JLabel lblNewLabel_1_1 = new JLabel("Conjunto Dominante Minimo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(729, 57, 243, 33);
		frame.getContentPane().add(lblNewLabel_1_1);

		/* ------ PANEL VER VERTICES */
		JPanel panelVerGrafo = new JPanel();
		panelVerGrafo.setBackground(new Color(255, 128, 128));
		panelVerGrafo.setBounds(468, 87, 207, 322);
		frame.getContentPane().add(panelVerGrafo);
		panelVerGrafo.setLayout(null);

		JButton btnNewButton_1 = new JButton("Ver vertices");
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(21, 11, 176, 23);
		panelVerGrafo.add(btnNewButton_1);

		// -------- scroll y tabla de vertices *-----
		JPanel panelVerVertices = new JPanel();
		panelVerVertices.setBounds(31, 45, 151, 266);
		panelVerGrafo.add(panelVerVertices);
		panelVerVertices.setLayout(new CardLayout(0, 0));

		JScrollPane scrollVerVertices = new JScrollPane();
		panelVerVertices.add(scrollVerVertices, "name_15177348750000");

		tableVerVertices = new JTable();
		tableVerVertices.setBackground(new Color(255, 255, 255));
		tableVerVertices.setForeground(new Color(0, 0, 0));
		tableVerVertices.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableVerVertices.setFillsViewportHeight(true);
		tableVerVertices.setCellSelectionEnabled(true);
		model_verVertices = new DefaultTableModel(new Object[][] {}, new String[] { "Vertice" });
		tableVerVertices.setModel(model_verVertices);
		tableVerVertices.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableVerVertices.setRowHeight(20);
		model_verVertices.addColumn("Derecha");
		model_verVertices.addColumn("Izquierda");

		scrollVerVertices.setViewportView(tableVerVertices);
		scrollVerVertices.repaint();

		// --------
		scrollVerVertices.setColumnHeaderView(tableVerVertices);
		btnNewButton_1.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VEMOS LOS VERTICES
				_vertices.imprimirGrafo();
				for (Integer vertice : _vertices.conjuntoVertices()) {
					model_verVertices.addRow(new Object[] { "Vertice: " + vertice });
				}
				panelAgregarVertices.repaint();
			}
		});

		// por cada vertice que haya en el conjunto de vertices, lo agregamos al panel
		// y le damos un nombre

		// *************** FIN PANEL CONJUNTO MINIMO DOMINANTE *************

	}

}
